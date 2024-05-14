package report;

import helpers.Helper;
import order.Order;
import order.OrderManager;

import java.time.LocalDate;
import java.util.List;

public class ReportManager {
    private final OrderManager orderManager;

    public ReportManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }
    private void showMenu() {
        System.out.println("---- Báo cáo ----");
        String[] main_menu = {
                "1. Hôm nay",
                "2. Hôm qua",
                "3. 7 ngày qua",
                "4. 30 ngày qua",
                "5. Quay lại",
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
    }

    public void run() {
        while (true) {
            showMenu();
            int select = Helper.getInt();
            switch (select) {
                case 1:
                    showReportToday();
                    break;
                case 2:
                    showReportYesterday();
                    break;
                case 3:
                    showReportWeek();
                    break;
                case 4:
                    showReportMonth();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        }
    }

    private void showReportToday() {
        System.out.println("Báo cáo hôm nay:");
        LocalDate date = LocalDate.now().minusDays(1);
        showReport(date);

    }
    private void showReportYesterday() {
        System.out.println("Báo cáo hôm qua:");
        LocalDate date = LocalDate.now().minusDays(2);
        showReport(date);
    }

    private void showReportWeek() {
        System.out.println("Báo cáo 7 ngày qua:");
        LocalDate date = LocalDate.now().minusDays(8);
        showReport(date);
    }

    private void showReportMonth() {
        System.out.println("Báo cáo 30 ngày qua:");
        LocalDate date = LocalDate.now().minusDays(31);
        showReport(date);
    }

    private void showReport(LocalDate date) {
        List<Order> orders = orderManager.getOrdersByDate(date);
        System.out.println("Số lượng đơn hàng: " + orders.size());
        double total = 0;
        double totalPaid = 0;
        int countOrderNotPaid = 0;
        Order maxPriceOrder = orders.get(0);
        for(Order order : orders) {
            if(!order.getStatus().equals("cancel")) {
                total += order.getTotal();
                if(order.getStatus().equals("paid")) {
                    totalPaid += order.getTotal();
                }else {
                    countOrderNotPaid++;
                }
            }

            if(order.getTotal() > maxPriceOrder.getTotal()) {
                maxPriceOrder = order;
            }
        }

        System.out.println("Doanh thu: " + total);
        System.out.println("Đã thanh toán: " + totalPaid);
        System.out.println("Số lượng đơn hàng chưa thanh toán: " + countOrderNotPaid);
        System.out.println("Đơn hàng có giá trị cao nhất: " + maxPriceOrder.getNumber() + " - " + maxPriceOrder.getTotal());
        System.out.println("=================================");
    }
}
