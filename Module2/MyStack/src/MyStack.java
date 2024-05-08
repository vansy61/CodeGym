import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> stack;

    MyStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T o) {
        this.stack.addFirst(o);
    }

    public T pop() {
        return this.stack.removeFirst();
    }

    public int size() {
        return this.stack.size();
    }
}















