public class TestThread extends Thread {
    int id;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread " + this.getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread t1 = new TestThread();
        TestThread t2 = new TestThread();
        TestThread t3 = new TestThread();

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
        System.out.println("main thread");

    }

}
