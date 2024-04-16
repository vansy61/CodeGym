public class Main {
    public static void main(String[] args) {
//        test array list
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(9);
        myArrayList.add(2);
        myArrayList.add(5);
        myArrayList.add(7);
        myArrayList.insert(2, 999);
        myArrayList.remove(1);
        myArrayList.readList();


        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insertFirst(1);
        myLinkList.insertFirst(10);
        myLinkList.insertFirst(20);


        myLinkList.insertLast(20);
        myLinkList.insertLast(100);

        System.out.println(myLinkList.tail.data);

    }
}