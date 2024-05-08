package product;

import java.io.Serializable;

public class Product implements Serializable  {
    private static int idCounter = 0;
    private static final long serialVersionUID = -9127312531253234L;
    private int id;
    private String sku;
    private String name;
    private int price;

    public Product() {}

    public Product(String sku, String name, int price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
