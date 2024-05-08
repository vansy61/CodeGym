import io.Input;
import order.OrderManager;
import product.ProductManager;

public class CafeManager {
    private static CafeManager instance;
    private CafeManager() {}

    public static CafeManager getInstance() {
        if(instance == null) {
            instance = new CafeManager();
        }
        return instance;
    }

    public void run() {
        ProductManager productManager = new ProductManager();
        OrderManager orderManager = new OrderManager(productManager);

        while(true) {
            showMenu();
            int option = Input.getInt();
            switch(option) {
                case 1:
                    productManager.run();
                    break;
                case 2:
                    orderManager.run();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("=======================");
        System.out.println("Welcome to cafe VS!");
        System.out.println("=======================");
        System.out.println("1. Quản lý sản phẩm");
        System.out.println("2. Quản lý đơn hàng");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
    }
}
