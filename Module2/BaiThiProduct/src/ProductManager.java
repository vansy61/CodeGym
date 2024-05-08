import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductManager {
    private final ProductView view;
    private final List<Product> list = new ArrayList<>();

    ProductManager(ProductView view) {
        this.view = view;
        for (int i = 0; i < 10; i++) {
            Product pr = new Product("aa" + i, "aaaa", "aaaa", 7000, 50);
            list.add(pr);
        }
    }

    public void run() {
        while (true) {
            view.showMainMenu();
            int select = Input.getInt();

            switch (select) {
                case 1:
                    displayProduct();
                    break;
                case 2:
                    newProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        }
    }

    private Product findProductBySku(String sku) {
        int index = findIndexBySku(sku);
        if(index == -1) {
            return null;
        }
        return list.get(index);
    }
    private int findIndexBySku(String sku) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSku().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    private Product getProduct() {
        Product product;
        do {
            System.out.println("Vui lòng nhập vào mã sản phẩm:");
            String sku = Input.getText();

            if(sku.isEmpty()) {
                return null;
            }

            product = findProductBySku(sku);
            if(product == null) {
                System.out.println("Không tìm thấy sản phẩm với mã sku này!");
            }
        }while (product == null);
        return product;
    }
    private void updateProduct() {

        Product product = getProduct();

        if(product == null) {
            return;
        }

        while (true) {
            System.out.println(product);
            view.showUpdateMenu();
            int select = Input.getInt();
            switch (select) {
                case 1:
                    update(product, "sku");
                    break;
                case 2:
                    update(product, "name");
                    break;
                case 3:
                    update(product, "price");
                    break;
                case 4:
                    update(product, "quantity");
                    break;
                case 5:
                    update(product, "description");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        }

    }
    private void update(Product product, String type) {
        switch (type) {
            case "sku":
                updateSku(product);
                break;
            case "name":
                product.setName(view.getInfoIsString("tên"));
                break;
            case  "price":
                product.setPrice(view.getInfoIsInt("giá"));
                break;
            case "quantity":
                product.setQuantity(view.getInfoIsInt("số lượng"));
                break;
            case "description":
                product.setDescription(view.getInfoIsString("mô tả"));
                break;
        }
        System.out.println("Cập nhật thành công!");
    }
    private void updateSku(Product product) {
        while(true) {
            String sku = view.getInfoIsString("sku");
            if(!Objects.equals(sku, product.getSku()) && checkExistSku(sku)) {
                System.err.println("Sku đã tồn tại!");
                continue;
            }
            product.setSku(sku);
            break;
        }
    }
    public void displayProduct() {
        int position = 0;
        int perPage = 5;

        while (true) {
            for (int i = position; i < position + perPage; i++) {
                if(i >= list.size()) {
                    return;
                }
                System.out.println(list.get(i));
            }
            position += perPage;
            System.out.println("Vui lòng bấm enter để xem tiếp!");
            Input.getText();
        }
    }

    public void newProduct() {
        Product product = new Product();

        while(true) {
            String sku = view.getInfoIsString("sku");
            if(checkExistSku(sku)) {
                System.err.println("Sku đã tồn tại!");
                continue;
            }
            product.setSku(sku);
            break;
        }

        product.setName(view.getInfoIsString("tên"));
        product.setPrice(view.getInfoIsInt("giá"));
        product.setQuantity(view.getInfoIsInt("số lượng"));
        product.setDescription(view.getInfoIsString("mô tả"));

        System.out.println(product);
        boolean confirm = view.showConfirm("Bạn có muốn thêm sản phẩm này không!");
        if(confirm) {
            list.add(product);
            System.out.println("Đã thêm sản phẩm thành công!");
        }
    }

    public void deleteProduct() {
        Product product = getProduct();

        if(product != null) {
            System.out.println(product);
            boolean confirm = view.showConfirm("Bạn có muốn xóa sản phẩm này không!");
            if(confirm) {
                list.remove(product);
                System.out.println("Đã xóa sản phẩm thành công!");
            }
        }
    }

    private boolean checkExistSku(String sku) {
        for (Product product : list) {
            if(product.getSku().equals(sku)) {
                return true;
            }
        }
        return false;
    }

}
