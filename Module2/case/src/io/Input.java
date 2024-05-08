package io;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            BeautyPrint.showError("Chỉ nhập số, vui lòng nhập lại:");
            return getInt();
        }
    }

    public static double getDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        }catch (Exception e) {
            BeautyPrint.showError("Chỉ nhập số, vui lòng nhập lại:");
            return getDouble();
        }
    }
    public static String getText() {
        return scanner.nextLine();
    }

}
