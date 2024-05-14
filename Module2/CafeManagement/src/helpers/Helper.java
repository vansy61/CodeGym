package helpers;

import java.text.Normalizer;
import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            System.err.println("Vui lòng nhập số!");
            return getInt();
        }
    }

    public static String getText() {
        return scanner.nextLine();
    }
    public static void close() {
        scanner.close();
    }


    public static boolean showConfirm(String mes) {
        System.out.println(mes);
        System.out.println("Bấm Y để xác nhận");
        String key = Helper.getText();
        return key.equalsIgnoreCase("y");
    }

    public static int getInfoIsInt(String title) {
        int value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Helper.getInt();
        }while (value < 1);
        return value;
    }
    public static String getInfoIsString(String title) {
        String value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Helper.getText();
        }while (value.isEmpty());
        return value;
    }

    public static String toLowerCaseNonAccentVn(String str) {
        str = str.toLowerCase();
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        str = str.replaceAll("[àáạảãâầấậẩẫăằắặẳẵ]", "a");
        str = str.replaceAll("[èéẹẻẽêềếệểễ]", "e");
        str = str.replaceAll("[ìíịỉĩ]", "i");
        str = str.replaceAll("[òóọỏõôồốộổỗơờớợởỡ]", "o");
        str = str.replaceAll("[ùúụủũưừứựửữ]", "u");
        str = str.replaceAll("[ỳýỵỷỹ]", "y");
        str = str.replaceAll("[đ]", "d");
        return str;

    }
}
