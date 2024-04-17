public class MyArrayList {
    private int size = 0;
    private static final int CAPACITY = 10;
    private Object[] items;

    MyArrayList() {
        this.items = new Object[CAPACITY];
    };

    MyArrayList(int capacity) {
        this.items = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public Object get(int index) {
        return this.items[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(this.items[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return this.indexOf(o) > 0;
    }

    public void add(Object o) {
        if(size == items.length - 1) {
        // Tạo mảng mới vơi kích thước lớn hơn
        }else {
            this.items[size] = o;
            size++;
        }
    }

    public void add(int index, Object o) {
        for (int i = index; i <= this.size; i++) {
            Object tempt = this.items[i];
            this.items[i] = o;
            o = tempt;
        }
        size++;
    }

    public void remove(int index) {
        if(index >= size) {
            return;
        }
        for (int i = index; i < this.size - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[--size] = null;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.items[i]);
        }
    }



}
