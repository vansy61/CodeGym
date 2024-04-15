package point;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;

    Point3D() {}

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float x) {
        this.z = x;
    }

    public float[] getXYZ() {
        return new float[]{this.getX(), this.getY(), this.getZ()};
    }

    public void  setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }


    public static void main(String[] a) {
        Point2D p2d = new Point2D(10,30);
        System.out.println(p2d);
        System.out.println(Arrays.toString(p2d.getXY()));

        Point3D p3d = new Point3D(30, 40, 60);
        System.out.println(p3d);
        System.out.println(Arrays.toString(p3d.getXYZ()));
    }
}
