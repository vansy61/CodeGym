package product;

import io.BeautyPrint;
import io.Input;

import java.util.ArrayList;
import java.util.Objects;

public class ProductController {
    private static ProductController instance;
    private static final String[] MAIN_MENU = {
            "1. Thêm sản phẩm",
            "2. Chỉnh sửa sản phẩm",
            "3. Xóa sản phẩm",
            "4. Danh sách sản phẩm",
            "5. Tìm kiếm sản phẩm",
            "6. Quay lại menu chính",
    };

    private final ProductManager productManage;
    private ProductController() {
        this.productManage = new ProductManager();
    }
    public static ProductController getInstance() {
        if(instance == null) {
            instance = new ProductController();
        }
        return  instance;
    }

    public void showMenu() {
        BeautyPrint.showSimpleMenu("Sản Phẩm", MAIN_MENU);
        int select = Input.getInt();

        switch (select) {
            case 1:
                newProduct();
                break;
            case 6:
                return;
            default:
                BeautyPrint.showError("Không có menu này, vui lòng nhập lại:");
                break;
        }
    }

    private void newProduct() {


    }
}
