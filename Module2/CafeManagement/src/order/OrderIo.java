package order;

import manager.CanStore;
import java.io.*;
import java.util.List;

public class OrderIo implements CanStore<Order> {
    private static final String dbPath = "data/db/order/";
    public File[] getFiles() {
        return new File(dbPath).listFiles();
    }

    public List<Order> importDb() {
        return readDb(getFiles());
    }

    public void saveDb(Order order) {
        try {
            FileOutputStream fos = new FileOutputStream(dbPath + order.getNumber() + ".cfvs");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(order);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Không thể lưu đơn hàng!");
        }
    }
}
