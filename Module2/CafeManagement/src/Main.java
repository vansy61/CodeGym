import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        CafeManager cafeManager = CafeManager.getInstance();
        cafeManager.run();
    }
}
