package order;


import helpers.Helper;

public class OrderView {
    void showMainMenu() {
        System.out.println("---- QUẢN LÝ ĐƠN HÀNG ----");
        String[] main_menu = {
                "1. Tìm kiếm",
                "2. Thêm mới",
                "3. Chỉnh sửa",
                "4. Hiển thị tất cả",
                "5. Quay lại menu chính"
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
    }

    void showHelpCommand() {
        System.out.println("Các lệnh hỗ trợ:");
        System.out.println("add sku quantity: thêm sản phẩm vào đơn hàng (add SKU01 30)");
        System.out.println("delete sku: xóa sản phẩm khỏi đơn hàng (delete SKU01)");
        System.out.println("update sku quantity: cập nhật số lượng sản phẩm trong đơn hàng (update SKU01 30)");
        System.out.println("pay: thanh toán đơn hàng");
        System.out.println("cancel: hủy đơn hàng");
        System.out.println("h: hiển thị lệnh hỗ trợ");
        System.out.println("q: thoát");
        System.out.println("Enter để tiếp tục...");
        Helper.getText();
    }

}
