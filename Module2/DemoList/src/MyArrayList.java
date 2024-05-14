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

    public void insert(int index, Object o) {
        for (int i = index; i <= this.size; i++) {
            Object tempt = this.container[i];
            this.container[i] = o;
            o = tempt;
        }
        size++;
    }

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
        for (int i = index; i < this.size - 1; i++) {
            this.container[i] = this.container[i + 1];
        }
        this.container[this.size - 1] = null;
        size--;
    }

    public void update(int index, Object value) {
        this.container[index] = value;
    }

    interface Abc {
        void abc();
    }
}