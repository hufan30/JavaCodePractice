package StaticFinalDemo;

import org.junit.Test;

public class ClassDemo {
    final static String key = "123";
    final String key2 = "234";
    static String key3 = "345";
    String abc = "abc";

    public void testKey(){
        System.out.println(key);
    }

    @Test
    public void test() {
        ClassDemo t = new ClassDemo();
        System.out.println(t.abc);
        t.testKey();
    }
}
