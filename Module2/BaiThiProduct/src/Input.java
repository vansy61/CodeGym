import java.util.Scanner;

public class Input {
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

}
