package src;

public class MyArrayList {
    public Object[] container;
    public int size = 0;
    private static final int CAPACITY = 10;

    public MyArrayList() {
        this.container = new Object[CAPACITY];
    }

    public void add(Object o) {
        this.container[size] = o;
        size++;
    }

    public void insert(int i, Object o) {}

    public void readList() {
        for (Object o : container) {
            if (o != null) {
                System.out.println(o);
            }

        }
    }

    public Object get(int index) {
        return this.container[index];
    }

    public void remove(int index) {

    }

    public void update(int index, Object value) {
        this.container[index] = value;
    }
}
