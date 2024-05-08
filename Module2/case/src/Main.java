import io.BeautyPrint;
import io.Input;
import product.ProductController;

public class Main {
    private static final String[] MAIN_MENU = {
      "1. Sản phẩm",
      "2. Đơn hàng",
      "3. Báo cáo",
      "4. Nhân sự",
      "5. Thoát",
    };
    public static void main(String[] args) {
        ProductController productController = ProductController.getInstance();

        while (true) {
            BeautyPrint.showSimpleMenu("Menu", MAIN_MENU);
            int select = Input.getInt();

            switch (select) {
                case 1:
                    productController.showMenu();
                    break;
                case 5:
                    return;
                default:
                    BeautyPrint.showError("Không có menu này, vui lòng nhập lại:");
                    break;
            }
        }

    }
}