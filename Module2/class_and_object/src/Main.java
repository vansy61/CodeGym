public class Main {
    public static void main(String[] args) {
//        testProduct();
//        testRectangle();
        testFan();
    }

    public static void testFan() {
        Fan fisrtFan = new Fan();
        fisrtFan.setColor("yellow");
        fisrtFan.setRadius(10);
        fisrtFan.setSpeed(fisrtFan.FAST);
        fisrtFan.setOn(true);

        Fan secondFan = new Fan();
        secondFan.setSpeed(secondFan.MEDIUM);

        System.out.println(fisrtFan.toString());
        System.out.println(secondFan.toString());
    }

    public static void testProduct() {
        Product firstProduct = new Product("Product 1", 1.2, 10);
        Product secondProduct = new Product("Product 2", 1.2, 10);

        System.out.println("Tên sản phẩm là:" + firstProduct.getName());
        System.out.println("Tên sản phẩm là:" + secondProduct.getName());
    }
    public static void testRectangle() {
        Rectangle testRectangle = new Rectangle(10, 20);
        int area = testRectangle.getArea();
        int perimeter = testRectangle.getPerimeter();

        System.out.println(area);
        System.out.println(perimeter);
    }
}