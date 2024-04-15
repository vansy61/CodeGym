package test;

import org.junit.Test;
import triangle.TriangleClassifier;

import static org.junit.Assert.assertEquals;

public class TriangleClassifierTest {

    @Test
    public void checkWithEquilateralTriangle() {
        int firstSide = 2;
        int secondSide = 2;
        int thirdSide = 2;
        String expected = "tam giác đều";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }

    @Test
    public void checkWithIsoscelesTriangle() {
        int firstSide = 2;
        int secondSide = 2;
        int thirdSide = 3;
        String expected = "tam giác cân";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }

    @Test
    public void checkWithNormalTriangle() {
        int firstSide = 3;
        int secondSide = 4;
        int thirdSide = 5;
        String expected = "tam giác thường";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }

    @Test
    public void checkWithASideIsNegative() {
        int firstSide = -1;
        int secondSide = 2;
        int thirdSide = 1;
        String expected = "không phải tam giác";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }

    @Test
    public void checkWithASideIsZero() {
        int firstSide = 0;
        int secondSide = 1;
        int thirdSide = 1;
        String expected = "không phải tam giác";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }

    @Test
    public void checkWithIsNotSideOfTriangle() {
        int firstSide = 8;
        int secondSide = 2;
        int thirdSide = 3;
        String expected = "không phải tam giác";

        String actual = TriangleClassifier.check(firstSide, secondSide, thirdSide);
        assertEquals(expected, actual);
    }
}
