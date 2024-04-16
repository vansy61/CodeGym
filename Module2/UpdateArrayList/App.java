import src.MyArrayList;
import src.MyLinkList;

public class App {
    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insertFirst(1);
        myLinkList.insertFirst(10);
        myLinkList.insertFirst(20);


        myLinkList.insertLast(20);
        myLinkList.insertLast(100);

        System.out.println(myLinkList.tail.data);

    }
}
