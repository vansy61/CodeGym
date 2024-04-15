package test;

import calc.NextDayCalculator;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextDayCalculatorTest {

    @Test
    public void calculatorWithDayLessThanDaysOfMonth() {
        int day = 1;
        int month = 1;
        int year = 2018;
        int[] expected = {2, 1, 2018};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void calculatorWithLastDayOfMonthHas31Days() {
        int day = 31;
        int month = 1;
        int year = 2018;
        int[] expected = {1, 2, 2018};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void calculatorWithLastDayOfMonthHas30Days() {
        int day = 30;
        int month = 4;
        int year = 2018;
        int[] expected = {1, 5, 2018};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void calculatorWithLastDayOfYear() {
        int day = 31;
        int month = 12;
        int year = 2018;
        int[] expected = {1, 1, 2019};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void calculatorWithLastDayOfFebruaryInALeapYear() {
        int day = 29;
        int month = 2;
        int year = 2020;
        int[] expected = {1, 3, 2020};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void calculatorWithLastDayOfFebruaryInANonLeapYear() {
        int day = 28;
        int month = 2;
        int year = 2018;
        int[] expected = {1, 3, 2018};

        NextDayCalculator calc = new NextDayCalculator();
        int[] actual = calc.calculator(day, month, year);
        assertArrayEquals(expected, actual);
    }
}
