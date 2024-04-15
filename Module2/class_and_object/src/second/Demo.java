package second;

class Demo implements Hello{
    Demo() {
        System.out.println("okokokokok");
    }
    @Override
    public void sleep() {
        System.out.println("Sleeping .....");
    }

    public static void main(String[] a) {
        Demo b = new Demo();
        b.sleep();
    }
}
