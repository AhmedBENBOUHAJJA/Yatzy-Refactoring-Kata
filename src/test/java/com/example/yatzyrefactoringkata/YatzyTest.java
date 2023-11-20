package com.example.yatzyrefactoringkata;

import entities.Yatzy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class YatzyTest {

        @ParameterizedTest
        @CsvSource({
                "2, 3, 4, 5, 1, 15",
                "3, 3, 4, 5, 1, 16"
        })
        void chanceScoresSumOfAllDice(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.chance(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "4, 4, 4, 4, 4, 50",
                "6, 6, 6, 6, 6, 50",
                "6, 6, 6, 6, 3, 0"
        })
        void yatzyScores50(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.yatzy(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 1",
                "1, 2, 1, 4, 5, 2",
                "6, 2, 2, 4, 5, 0",
                "1, 2, 1, 1, 1, 4"
        })
        void testOnes(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.ones(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 2, 6, 4",
                "2, 2, 2, 2, 2, 10"
        })
        void testTwos(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.twos(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 2, 3, 6",
                "2, 3, 3, 3, 3, 12"
        })
        void testThrees(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.threes(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "4, 4, 4, 5, 5, 12",
                "4, 4, 5, 5, 5, 8",
                "4, 5, 5, 5, 5, 4"
        })
        void testFours(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fours());
        }

        @ParameterizedTest
        @CsvSource({
                "4, 4, 4, 5, 5, 10",
                "4, 4, 5, 5, 5, 15",
                "4, 5, 5, 5, 5, 20"
        })
        void testFives(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fives());
        }

        @ParameterizedTest
        @CsvSource({
                "4, 4, 4, 5, 5, 0",
                "4, 4, 6, 5, 5, 6",
                "6, 5, 6, 6, 5, 18"
        })
        void testSixes(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).sixes());
        }

        @ParameterizedTest
        @CsvSource({
                "3, 4, 3, 5, 6, 6",
                "5, 3, 3, 3, 5, 10",
                "5, 3, 6, 6, 5, 12"
        })
        void testScorePair(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.scorePair(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "3, 3, 5, 4, 5, 16",
                "3, 3, 5, 5, 5, 16"
        })
        void testTwoPair(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.twoPair(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "3, 3, 3, 4, 5, 9",
                "5, 3, 5, 4, 5, 15",
                "3, 3, 3, 3, 5, 9"
        })
        void testThreeOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.threeOfAKind(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "3, 3, 3, 3, 5, 12",
                "5, 5, 5, 4, 5, 20",
                "2, 2, 2, 1, 2, 8"
        })
        void testFourOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.fourOfAKind(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 15",
                "2, 3, 4, 5, 1, 15",
                "1, 2, 2, 4, 5, 0"
        })
        void testSmallStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.smallStraight(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "6, 2, 3, 4, 5, 20",
                "2, 3, 4, 5, 6, 20",
                "1, 2, 2, 4, 5, 0"
        })
        void testLargeStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.largeStraight(d1, d2, d3, d4, d5));
        }

        @ParameterizedTest
        @CsvSource({
                "6, 2, 2, 2, 6, 18",
                "2, 3, 4, 5, 6, 0"
        })
        void testFullHouse(int d1, int d2, int d3, int d4, int d5, int expected) {
                assertEquals(expected, Yatzy.fullHouse(d1, d2, d3, d4, d5));
        }

}
