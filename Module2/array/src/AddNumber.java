import java.util.Arrays;
import java.util.Scanner;

public class AddNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số muốn thêm:");
        int number = input.nextInt();
        System.out.println("Nhập vào vị trí muốn thêm:");
        int index = input.nextInt();

        int[] test_arr = {2,4,6,2,8,0,0,0,0,0};

        if(index < 0 || index >= test_arr.length) {
            System.out.println("Index nhập vào không hợp lệ!");
            return;
        }
        insertArray(test_arr, index, number);
        System.out.println(Arrays.toString(test_arr));
    }

    public static  void  insertArray(int[] arr, int index, int number) {
        for (; index < arr.length; index++) {
            int tempt;
            tempt = arr[index];
            arr[index] = number;
            number = tempt;
        }
    }
}
