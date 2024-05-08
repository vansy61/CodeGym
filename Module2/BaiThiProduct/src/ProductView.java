public class ProductView {

    public void showMainMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        String[] main_menu = {
                "1. Xem danh sách",
                "2. Thêm mới",
                "3. Cập nhật",
                "4. Xóa",
                "5. Thoát",
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
    }

    public void showUpdateMenu() {
        System.out.println("---- CHỈNH SỬA SAẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        String[] main_menu = {
                "1. Mã sản phẩm",
                "2. Tên sản phẩm",
                "3. Giá",
                "4. Số Lượng",
                "5. Mô tả",
                "6. Quay lại menu chính",
        };

        for(String menu : main_menu) {
            System.out.println(menu);
        }
    }

    public boolean showConfirm(String mes) {
        System.out.println(mes);
        System.out.println("Bấm Y để xác nhận");
        String key = Input.getText();
        return key.equalsIgnoreCase("y");
    }
    public String getInfoIsString(String title) {
        String value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Input.getText();
        }while (value.isEmpty());
        return value;
    }

    public int getInfoIsInt(String title) {
        int value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Input.getInt();
        }while (value < 0);
        return value;
    }


}
