package StaticFinalDemo;

import java.util.HashMap;
import java.util.Map;

public class StaticDemo {
    static class testStaticClass {
        static Map map = new HashMap<>();
        int i = 1;

        public static void set() {
            map.put(1, 1);
        }

        public static void get() {
            map.getOrDefault(1, 0);
        }
    }

    /**
     * static  class中的不是自动为static;
     *
     * @param args
     */
    public static void main(String[] args) {
        testStaticClass.set();
        testStaticClass.get();
        testStaticClass.map.put(1, 1);
    }
}
