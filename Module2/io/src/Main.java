import java.io.*;

public class Main {
    public static void main(String[] args) {

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("luong 1");
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    System.out.println("luong 2");
                }
            }
        });

        th1.start();
        th2.start();
    }
}