package circle;

public class Cylinder extends Circle {
    private double height;

    Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getV() {
        return getS() * height;
    }

    @Override
    public String toString() {
        return "Thể tích là: " + getV();
    }


    public static void main(String[] a){
        Circle test1 = new Circle(2.3, "blue");
        System.out.println(test1.toString());
        Cylinder test = new Cylinder(2.3, "blue", 10);
        System.out.println(test.toString());
    }
}
