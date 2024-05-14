package order;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import helpers.Helper;
import manager.ShowListable;
import product.Product;
import product.ProductManager;

public class OrderManager implements ShowListable<Order> {
    private final OrderView view;
    private final ProductManager productManager;
    private final List<Order> list;

    public OrderManager(ProductManager productManager) {

        this.productManager = productManager;
        this.view = new OrderView();
        this.list = new OrderIo().importDb();
    }



    public void run() {
        while (true) {
            view.showMainMenu();
            int select = Helper.getInt();
            switch (select) {
                case 1:
                    searchOrder();
                    break;
                case 4:
                    showAll();
                    break;
                case 2:
                    newOrder();
                    break;
                case 3:
                    showOrder();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }

        }
    }

    public void showAll() {
        if(list.isEmpty()) {
            System.err.println("Chưa có đơn hàng nào!");
            return;
        }
        showList(list);
    }

    public void searchOrder() {
        while (true) {
            System.out.println("Nhập từ khóa tìm kiếm (số đơn hàng, tên khách hàng, số điện thoại, trạng thái).");
            System.out.println("Nếu kết quả tìm kiếm chỉ có một đơn hàng sẽ tự động mở chỉnh sửa.");
            System.out.println("Tối thiểu 3 ký tự (nhập q để thoát):");
            String select = Helper.getText();

            if(select.equalsIgnoreCase("q")) {
                return;
            }

            if(select.length() < 3) {
                System.out.println("Vui lòng nhập ít nhất 3 ký tự!");
                continue;
            }

            searchOrder(select);
        }

    }

    public void searchOrder(String key) {
        List<Order> result = new ArrayList<>();
        key = Helper.toLowerCaseNonAccentVn(key);
        for(Order order : list) {
            if(
                Helper.toLowerCaseNonAccentVn(order.getCustomerName()).contains(key) ||
                Helper.toLowerCaseNonAccentVn(order.getNumber()).contains(key) ||
                Helper.toLowerCaseNonAccentVn(order.getReadableStatus()).contains(key) ||
                Helper.toLowerCaseNonAccentVn(order.getPhoneNumber()).contains(key)
            ) {
                result.add(order);
            }
        }
        if(result.isEmpty()) {
            System.err.println("Không tìm thấy đơn hàng!");
            return;
        }
        if(result.size() > 1) {
            System.out.println("Đã tìm thấy " + result.size() + " đơn hàng!");
            showList(result);
            return;
        }
        showOrder(result.get(0));
    }

    public void newOrder() {
        Order order = new Order();
        String customerName = Helper.getInfoIsString("tên khách hàng");
        String phoneNumber = "";
        while (!phoneNumber.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
               phoneNumber = Helper.getInfoIsString("số điện thoại");
        }
        order.setCustomerName(customerName);
        order.setPhoneNumber(phoneNumber);
        list.add(order);
        System.out.println("Tạo đơn hàng thành công!");
        showOrder(order);
    }

    public Order findOrderByNumber(String number) {
        for(Order order : list) {
            if(order.getNumber().equals(number)) {
                return order;
            }
        }
        return null;
    }

    private void showOrder() {
        while (true) {
            System.out.println("Vui lòng nhập số đơn hàng muốn xem:");
            String number = Helper.getText();
            if(number.isEmpty()) {
                break;
            }

            Order order = findOrderByNumber(number);
            if(order == null) {
                System.err.println("Không tìm thấy đơn hàng với số này!");
                continue;
            }
            showOrder(order);
            break;
        }

    }


    private void showOrder(Order order) {
        while (true) {
            System.out.println(order);
            System.out.println("Vui lòng nhập lệnh của bạn (nhập h để xem gợi ý, nhập q để thoát):");
            String select = Helper.getText();
            if(select.equalsIgnoreCase("q")) {
                return;
            }
            if(select.equalsIgnoreCase("h")) {
                view.showHelpCommand();
                return;
            }

            if(select.equalsIgnoreCase("cancel")) {
                order.setStatus("cancel");
                return;
            }

            if(select.equalsIgnoreCase("pay")) {
                order.setStatus("paid");
                return;
            }

            String[] command = select.split(" ");
            if(command.length == 3) {
                int quantity;
                try {
                    quantity = Integer.parseInt(command[2]);
                    if(quantity <= 0) {
                        System.err.println("Số lượng phải lớn hơn 0!");
                        continue;
                    }
                }catch (NumberFormatException e) {
                    System.err.println("Số lượng không hợp lệ!");
                    continue;
                }

                Product product = productManager.findProductBySku(command[1]);
                if(product == null) {
                    System.err.println("Không tìm thấy sản phẩm với sku này!");
                    continue;
                }

                switch (command[0]) {
                    case "add":
                        addOrderItem(order, product, quantity);
                        break;
                    case "update":
                        updateOrderItem(order, product, quantity);
                        break;
                }
                continue;
            }

            if(command.length == 2) {
                if (command[0].equals("delete")) {
                    Product product = productManager.findProductBySku(command[1]);
                    if(product == null) {
                        System.err.println("Không tìm thấy sản phẩm với sku này!");
                        continue;
                    }
                    deleteOrderItem(order, product);
                }
                continue;
            }

            System.err.println("Lệnh không hợp lệ, nhập h để xem gợi ý!");

        }
    }

    public void deleteOrderItem(Order order, Product product) {
        OrderItem orderItem = order.getOrderItem(product.getSku());
        if(orderItem == null) {
            System.err.println("Đơn hàng không có sản phẩm với sku này!");
            return;
        }

        order.deleteOrderItem(orderItem);
        order.updateTotal();
    }

    public void updateOrderItem(Order order, Product product, int quantity) {
        OrderItem orderItem = order.getOrderItem(product.getSku());
        if(orderItem == null) {
            System.err.println("Đơn hàng không có sản phẩm với sku này!");
            return;
        }

        orderItem.setQuantity(quantity);
        orderItem.setTotal(product.getPrice() * orderItem.getQuantity());
        order.updateTotal();
    }

    public void addOrderItem(Order order, Product product, int quantity) {
        int total = product.getPrice() * quantity;
        OrderItem orderItem;
        orderItem = order.getOrderItem(product.getSku());
        if(orderItem == null) {
            orderItem = new OrderItem(product.getSku(), product.getName(), quantity, product.getPrice(), total);
            order.addOrderItem(orderItem);
        }else {
            orderItem.addQuantity(quantity);
            orderItem.setTotal(product.getPrice() * orderItem.getQuantity());
        }

        order.updateTotal();

    }

    public List<Order> getOrdersByDate(LocalDate startDate) {
        List<Order> result = new ArrayList<>();
        for(Order order : list) {
            if(order.getDate().isAfter(startDate)) {
                result.add(order);
            }
        }
        return result;
    }
}
