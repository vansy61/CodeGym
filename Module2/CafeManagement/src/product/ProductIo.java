package product;

import manager.Storageable;

import java.io.*;
import java.util.List;

public class ProductIo implements Storageable<Product> {
    public File[] getFiles() {
        return new File("data/db/product").listFiles();
    }

    public List<Product> importDb() {
        return readDb(getFiles());
    }

    void removeDb(Product product) {
        File f = new File("data/db/product/" + product.getSku() + ".cfvs");
        f.delete();
    }


    @Override
    public void saveDb(Product product) {
        try {
            FileOutputStream fos = new FileOutputStream("data/db/product/" + product.getSku() + ".cfvs");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(product);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
