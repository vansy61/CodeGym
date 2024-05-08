package order;
import java.util.ArrayList;
import java.util.List;
import io.Input;
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
            int select = Input.getInt();
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
            System.out.println("Nhập từ khóa tìm kiếm (số đơn hàng, tên khách hàng).");
            System.out.println("Nếu kết quả tìm kiếm chỉ có một đơn hàng sẽ tự động mở chỉnh sửa.");
            System.out.println("Tối thiểu 3 ký tự (nhập q để thoát):");
            String select = Input.getText();

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
        for(Order order : list) {
            if(order.getCustomerName().contains(key) || order.getNumber().contains(key)) {
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
        String customerName = view.getInfoIsString("tên khách hàng");
        order.setCustomerName(customerName);
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
            String number = Input.getText();
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
            String select = Input.getText();
            if(select.equalsIgnoreCase("q")) {
                return;
            }
            if(select.equalsIgnoreCase("h")) {
                showHelpCommand();
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
            }

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


    private void showHelpCommand() {
        System.out.println("Các lệnh hỗ trợ:");
        System.out.println("add sku quantity: thêm sản phẩm vào đơn hàng (add SKU01 30)");
        System.out.println("delete sku: xóa sản phẩm khỏi đơn hàng (delete SKU01)");
        System.out.println("update sku quantity: cập nhật số lượng sản phẩm trong đơn hàng (update SKU01 30)");
        System.out.println("pay: thanh toán đơn hàng");
        System.out.println("cancel: hủy đơn hàng");
        System.out.println("h: hiển thị lệnh hỗ trợ");
        System.out.println("q: thoát");
        System.out.println("Enter để tiếp tục...");
        Input.getText();
    }




}
