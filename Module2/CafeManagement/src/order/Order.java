package order;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = -9127312531253234L;
    private final String number;
    private String customerName;
    private String date;
    private final List<OrderItem> orderItems = new ArrayList<>();

    private double total;
    private String status = "ready";

    public Order() {
        this.number = "CF" + (int) (Math.random() * 100000);
        this.date = getCurrentDate();

    }


    public String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formatter);
    }

    public String getStatus() {
        if(status.equals("ready")) {
            return "Chưa thanh toán";
        }
        if(status.equals("paid")) {
            return "Đã thanh toán";
        }
        return "Đã hủy";
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderItem getOrderItem(String sku) {
        for (OrderItem orderItem : orderItems) {
            if(orderItem.getProductSku().equals(sku)) {
                return orderItem;
            }
        }
        return null;
    }
    public void addOrderItem(OrderItem orderItem) {

        this.orderItems.add(orderItem);
    }

    public void deleteOrderItem(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }

    public void updateTotal() {
        this.total = 0;
        for (OrderItem orderItem : orderItems) {
            this.total += orderItem.getTotal();
        }
        new OrderIo().saveDb(this);
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder orderItemsStr = new StringBuilder();
        if(orderItems.isEmpty()) {
            orderItemsStr.append("Chưa có sản phẩm nào!\n");
        }else {
            for (OrderItem orderItem : orderItems) {
                orderItemsStr.append(orderItem.toString()).append("\n");
            }
        }


        return  "\nĐƠN HÀNG " + number + "\n" +
                "=====================================\n" +
                "Khách hàng: " + customerName + "\n" +
                "Ngày tạo: " + date + "\n" +
                "-------------------------------------\n" +
                orderItemsStr+
                "-------------------------------------\n" +
                "Tổng tiền: " + total + "\n" +
                "Trạng thái: " + getStatus() + "\n";


    }

    public String getCustomerName() {
        return customerName;
    }
}
