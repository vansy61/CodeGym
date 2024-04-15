import java.util.Scanner;

public class SumCheo {
    public static void main(String[] a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào kích thước ma trân: ");
        int size = input.nextInt();

        double[][] matrix = new double[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Nhập vào phần tử " + i + ", " + j);
                double number = input.nextDouble();
                matrix[i][j] = number;
            }
        }

        System.out.println("Mảng bạn vừa nhập là:");
        showArr(matrix);

        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        System.out.println("Tổng đường chéo chính là:" + sum);

    }


    public static void showArr(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.print("\n");
        }
    }
}
