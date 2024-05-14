package product;

public class ProductView {

    public void showMainMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        String[] main_menu = {
                "1. Xem danh sách",
                "2. Thêm mới",
                "3. Cập nhật",
                "4. Xóa",
                "5. Quay lại menu chính"
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
    }

    public void showUpdateMenu() {
        System.out.println("---- CHỈNH SỬA SẢN PHẨM ----");
        String[] main_menu = {
                "1. Mã sản phẩm",
                "2. Tên sản phẩm",
                "3. Giá",
                "4. Quay lại",
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
        System.out.println("Chọn chức năng theo số (để tiếp tục):");

    }






}
