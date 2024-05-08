package product;

import io.BeautyPrint;

import java.util.Objects;

public class Product {
    private static int LASTED_ID = 0;
    int id;
    String name;
    double price;
    String description;

    Product(String name, double price, String description) {
        this.id = ++LASTED_ID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
