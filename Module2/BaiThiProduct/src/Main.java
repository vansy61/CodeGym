public class Main {
    public static void main(String[] args) {
        ProductView view = new ProductView();
        ProductManager productManager = new ProductManager(view);
        productManager.run();
        Input.close();
        System.out.println("Good bye!");
    }
}