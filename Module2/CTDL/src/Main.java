public class Main {
    public static void main(String[] args) {

        MyArrayList test = new MyArrayList();

        test.add(1);
        test.add(2);
        test.add(3);
        test.show();

        System.out.println(test.indexOf(5));
        System.out.println(test.size());
        System.out.println(test.get(0));
        test.remove(7);
        test.show();

    }
}