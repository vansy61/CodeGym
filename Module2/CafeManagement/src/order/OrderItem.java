package order;

import java.io.Serializable;

public class OrderItem  implements Serializable {
    private static final long serialVersionUID = -9127312531253234L;
    private final String productSku;
    private final String productName;
    private int quantity;
    private double price;
    private double total;

    public OrderItem(String productSku, String productName, int quantity, double price, int total) {
        this.productSku = productSku;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String getProductSku() {
        return productSku;
    }

    public int getQuantity() {
        return quantity;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productSku='" + productSku + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
