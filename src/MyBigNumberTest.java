public class MyBigNumberTest implements IReceiver {

   
    public static void main(String[] args) {

        TestCase1();
        TestCase2();
        TestCase3();
        TestCase4();
        TestCase5();
        TestCase6();
        TestCase7();
    }

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }

    
    public static void TestCase1() {
        
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 1:\n");
        mybignumber.sum("99", "999");
		
    }

    public static void TestCase2() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 2:\n");
        mybignumber.sum("9999", "999");
    }

    public static void TestCase3() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 3:\n");
        mybignumber.sum("99", "99");
    }

    public static void TestCase4() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 4:\n");
        mybignumber.sum("A", "999");
    }

    public static void TestCase5() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 5:\n");
        mybignumber.sum("89", "98*");
    }
    public static void TestCase6() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 6:\n");
        mybignumber.sum("-1", "12");
    }
    public static void TestCase7() {
        MyBigNumber mybignumber = new MyBigNumber();
        System.out.println("Case 7:\n");
        mybignumber.sum("", "");
    }
}
