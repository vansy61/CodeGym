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

    public static String getInfoIsStringNotEmpty(String title) {
        String value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = scanner.nextLine();
        }while (value.isEmpty());
        return value;
    }

}
