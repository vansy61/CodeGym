public class Rectangle {
    int width;
    int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getArea() {
        return this.width * this.height;
    }

    int getPerimeter() {
        return (this.width + this.height) * 2;
    }
}
