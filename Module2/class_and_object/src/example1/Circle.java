package example1;

public class Circle {
    static final double PI = 3.14;
    static private int lastedId = 0;
    static private int circleCount = 0;
    private int id;
    private float radius;


    Circle(float radius) {
        this.radius = radius;
        this.id = ++Circle.lastedId;
        Circle.circleCount++;
    }
}
