public class MyArrayList {
    int size = 0;
    static final int CAPACITY = 10;
    Object[] items;

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

    public void add(Object o) {
        if(size == items.length - 1) {
//            Tạo mảng mới vơi kích thước lớn hơn
        }else {
            this.items[size] = o;
            size++;
        }
    }

    public void remove(int index) {
        if(index >= size) {
            return;
        }
        for (int i = index; i < size; i++) {
            if(i + 1 == size ) {
                this.items[i] = null;
            }else {
                this.items[i] = this.items[i + 1];
            }
        }
        size--;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.items[i]);
        }
    }
    


}
