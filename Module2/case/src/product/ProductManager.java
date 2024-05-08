package product;

import java.util.ArrayList;

public class ProductManager {
    private final ArrayList<Product> products = new ArrayList<>();
    public void add(Product pr) throws Exception {
        products.add(pr);
        writeToFile();
    }

    private void writeToFile() throws Exception {

    }
}
