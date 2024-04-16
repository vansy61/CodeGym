package src;

public class MyLinkList {
    public Node head;
    public Node tail;

    public MyLinkList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(Object value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.link = this.head;
            this.head = node;
        }
    }

    public void insertLast(Object value) {
        Node node = new Node(value);

        if (this.tail == null) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.link = node;
            this.tail = node;
        }
    }
}
