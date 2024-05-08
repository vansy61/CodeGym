package order;

import manager.Storageable;
import product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIo implements Storageable<Order> {
    public File[] getFiles() {
        return new File("data/db/order").listFiles();
    }

    public List<Order> importDb() {
        return readDb(getFiles());
    }

    public void saveDb(Order order) {
        try {
            FileOutputStream fos = new FileOutputStream("data/db/order/" + order.getNumber() + ".cfvs");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(order);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
