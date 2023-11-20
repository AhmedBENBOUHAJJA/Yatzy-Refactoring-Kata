package entities;

import java.util.Arrays;

public class Yatzy {

    private final int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1, d2, d3, d4, d5};
    }

    public static int chance(int... dice) {
        return Arrays.stream(dice).sum();
    }

    public static int yatzy(int... dice) {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 : 0;
    }

    public static int ones(int... dice) {
        return sumOfSpecificNumber(dice, 1);
    }

    public static int twos(int... dice) {
        return sumOfSpecificNumber(dice, 2);
    }

    public static int threes(int... dice) {
        return sumOfSpecificNumber(dice, 3);
    }

    public static int scorePair(int... dice) {
        return getSumOfMatching(dice, 2);
    }

    public static int twoPair(int... dice) {
        int[] counts = getCountsArray(dice);
        int pairs = 0;
        int sum = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairs++;
                sum += (i + 1) * 2;
            }
        }
        return pairs == 2 ? sum : 0;
    }

    public static int threeOfAKind(int... dice) {
        return getSumOfMatching(dice, 3);
    }

    public static int fourOfAKind(int... dice) {
        return getSumOfMatching(dice, 4);
    }

    public static int smallStraight(int... dice) {
        return isStraight(dice) ? 15 : 0;
    }

    public static int largeStraight(int... dice) {
        return isStraight(dice) ? 20 : 0;
    }

    public static int fullHouse(int... dice) {
        int[] counts = getCountsArray(dice);
        boolean hasThree = false;
        boolean hasTwo = false;

        for (int count : counts) {
            if (count == 3) hasThree = true;
            if (count == 2) hasTwo = true;
        }

        return hasThree && hasTwo ? chance(dice) : 0;
    }

    public int fours() {
        return countAndSum(4);
    }

    public int fives() {
        return countAndSum(5);
    }

    public int sixes() {
        return countAndSum(6);
    }

    private static int sumOfSpecificNumber(int[] dice, int number) {
        return Arrays.stream(dice).filter(d -> d == number).sum();
    }

    private static int getSumOfMatching(int[] dice, int count) {
        int[] counts = getCountsArray(dice);
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= count) {
                return (i + 1) * count;
            }
        }
        return 0;
    }

    private int countAndSum(int number) {
        return Arrays.stream(dice).filter(d -> d == number).sum();
    }

    private static int[] getCountsArray(int[] dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private static boolean isStraight(int[] dice) {
        Arrays.sort(dice);
        return Arrays.equals(dice, new int[]{1, 2, 3, 4, 5}) || Arrays.equals(dice, new int[]{2, 3, 4, 5, 6});
    }
}
