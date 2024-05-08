import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 3, 17, 5, 7, 9, 3, 6, 7};
        int x = 3;
        int count = 0;

        for(int item : arr) {
            if(item == x) {
                count++;
            }
        }

        System.out.println("Số " + x + " xuất hiện " + count + " lần!");
    }


    // Hàm sắp xếp nổi bọt

    public int binarySearch(ArrayList[] arr, int left, int right, int value) {
        if(left < right) {
            return -1;
        }
        int middle = (right - left) / 2;

        if()
    }

}