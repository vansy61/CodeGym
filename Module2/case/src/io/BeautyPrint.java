package io;

public class BeautyPrint {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_INFO = "\033[0;34m";
    public static void showSimpleMenu(String title, String[] items) {
        System.out.println("=======================================");
        System.out.println(title);
        System.out.println("=======================================");
        for(String item : items) {
            System.out.println(item);
        }
        System.out.println("Vui lòng chọn!");
    }

    public static void showError(String msg) {
        System.out.println(ANSI_RED + msg + ANSI_RESET);
    }
    public static void showInfo(String msg) {
        System.out.println(ANSI_INFO + msg + ANSI_RESET);
    }

}
