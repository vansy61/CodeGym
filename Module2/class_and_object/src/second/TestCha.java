package second;

public class TestCha extends Test{
    TestCha(int a) {
        this();
        System.out.println("kakakak");
    }
    TestCha(){

    };
    public void go() {
        System.out.println("go gogog");
    }

    public static void main(String[] a){

        Test vb = new TestCha(1);
    }
}
