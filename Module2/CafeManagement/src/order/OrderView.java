package order;


public class OrderView {
    public void showMainMenu() {
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
}
