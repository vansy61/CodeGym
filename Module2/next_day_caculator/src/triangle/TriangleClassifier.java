package triangle;

public class TriangleClassifier {
    public static String check(int firstSide, int secondSide, int thirdSide) {
        if(
            firstSide < secondSide + thirdSide &&
            secondSide < firstSide + thirdSide &&
            thirdSide < firstSide + secondSide
        ){
            if(firstSide == secondSide && secondSide == thirdSide) {
                return "tam giác đều";
            }

            if(firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide) {
                return "tam giác cân";
            }

            return "tam giác thường";
        }

        return "không phải tam giác";
    }
}
