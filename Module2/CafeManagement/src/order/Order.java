package order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = -9127312531253234L;
    public static Object Status;
    private final String number;
    private String customerName;
    private String phoneNumber;
    private LocalDate date;
    private final List<OrderItem> orderItems = new ArrayList<>();

    private double total;
    private String status = "ready";

    public Order() {
        this.number = "CF" + (int) (Math.random() * 100000);
        this.date = LocalDate.now();

    }

    public String getReadableStatus() {
        if(status.equals("ready")) {
            return "Chưa thanh toán";
        }
        if(status.equals("paid")) {
            return "Đã thanh toán";
        }
        return "Đã hủy";
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        if(checkStatusBeforeAction()) {
            return;
        }
        this.orderItems.add(orderItem);
    }

    public void deleteOrderItem(OrderItem orderItem) {
        if(checkStatusBeforeAction()) {
            return;
        }
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

    public void setStatus(String status) {
        if(checkStatusBeforeAction()) {
            return;
        }
        this.status = status;
        new OrderIo().saveDb(this);
        System.out.println("Cập nhật trạng thái thành công!");
        return;

    }

    public String getStatus() {
        return status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getTotal() {
        return total;
    }

    public LocalDate getDate() {
        return date;
    }

    private boolean checkStatusBeforeAction() {
        if(!status.equals("ready")) {
            System.err.println("Hành động không thể thực hiện vì đơn hàng đã " + getReadableStatus() + "!");
            return true;
        }
        return false;
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
                "Số điện thoại: " + phoneNumber + "\n" +
                "Ngày tạo: " + date + "\n" +
                "-------------------------------------\n" +
                orderItemsStr+
                "-------------------------------------\n" +
                "Tổng tiền: " + total + "\n" +
                "Trạng thái: " + getReadableStatus() + "\n";


    }

}
