package product;

import helpers.Helper;
import manager.ShowListable;

import java.util.List;
import java.util.Objects;
public class ProductManager implements ShowListable<Product> {
    private final ProductView view;
    private final List<Product> list;

    public ProductManager() {
        this.view = new ProductView();
        this.list = new ProductIo().importDb();
    }

    public void run() {
        while (true) {
            view.showMainMenu();
            int select = Helper.getInt();

            switch (select) {
                case 1:
                    showAll();
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

    public void showAll() {
        if(list.isEmpty()) {
            System.err.println("Không có sản phẩm nào!");
            return;
        }
        showList(list);
    }

    public Product findProductBySku(String sku) {
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

    public Product getProduct() {
        Product product;
        do {
            System.out.println("Vui lòng nhập vào mã sản phẩm:");
            String sku = Helper.getText();

            if(sku.isEmpty()) {
                return null;
            }

            product = findProductBySku(sku);
            if(product == null) {
                System.err.println("Không tìm thấy sản phẩm với mã sku này!");
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
            int select = Helper.getInt();
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
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        }

    }
    private void update(Product product, String type) {
        new ProductIo().removeDb(product);
        switch (type) {
            case "sku":
                updateSku(product);
                break;
            case "name":
                product.setName(Helper.getInfoIsString("tên"));
                break;
            case  "price":
                product.setPrice(Helper.getInfoIsInt("giá"));
                break;
        }
        new ProductIo().saveDb(product);
        System.out.println("Cập nhật thành công!");
    }
    private void updateSku(Product product) {
        while(true) {
            String sku = Helper.getInfoIsString("sku");
            if(!Objects.equals(sku, product.getSku()) && checkExistSku(sku)) {
                System.err.println("Sku đã tồn tại!");
                continue;
            }
            product.setSku(sku);
            break;
        }
    }


    public void newProduct() {
        Product product = new Product();

        while(true) {
            String sku = Helper.getInfoIsString("sku");
            if(checkExistSku(sku)) {
                System.err.println("Sku đã tồn tại!");
                continue;
            }
            product.setSku(sku);
            break;
        }

        product.setName(Helper.getInfoIsString("tên"));
        product.setPrice(Helper.getInfoIsInt("giá"));

        System.out.println(product);
        boolean confirm = Helper.showConfirm("Bạn có muốn thêm sản phẩm này không!");
        if(confirm) {
            list.add(product);
            new ProductIo().saveDb(product);
            System.out.println("Đã thêm sản phẩm thành công!");
        }
    }

    public void deleteProduct() {
        Product product = getProduct();

        if(product != null) {
            System.out.println(product);
            boolean confirm = Helper.showConfirm("Bạn có muốn xóa sản phẩm này không!");
            if(confirm) {
                list.remove(product);
                new ProductIo().removeDb(product);
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
