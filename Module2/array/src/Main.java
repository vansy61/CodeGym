import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] test_array = {5,7,8,1,9,2,3,0,6};

        System.out.println("Nhập vào 1 số!");
        int number = input.nextInt();

        int index = -1;

        for (int i = 0; i < test_array.length; i++) {
            if(number == test_array[i]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (; index < test_array.length - 1; index++) {
                test_array[index] = test_array[index + 1];
            }

            test_array[test_array.length - 1] = 0;
            System.out.println(Arrays.toString(test_array));
        }else {
            System.out.println("Khong tìm thấy số cần xóa!");
        }


    }
}