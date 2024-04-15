import java.util.Arrays;

public class MergeArray {
    public static void main(String[] abc) {
        int[] firstArr = {3,4,5,7,8,5};
        int[] secondArr = {5,100,432};

        int[] resultArr = new int[firstArr.length + secondArr.length];
        
        for (int i = 0; i < firstArr.length; i++) {
            resultArr[i] = firstArr[i];
        }
        for (int i = 0; i < secondArr.length; i++) {
            resultArr[firstArr.length + i] = secondArr[i];
        }

        System.out.println(Arrays.toString(resultArr));
    }
}
