package GenericClassDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List<String> stringList  = new ArrayList<>(Arrays.asList("1","2","3"));
        print(stringList);
        /**
         * 这里也是厉害，泛型直接放入是不可以的
         */
//        stringList.add(111);

    }

    /**
     * 但是如果方法的参数没有限制泛型，即使传入的是一个限定了泛型的List，也能随意向里面放入值；
     * @param list
     */
    public static void print(List list){
        list.add(111);
        list.add("111");
        Object o = list.get(0);
        System.out.println(o);
    }

    public static void print1(List<? extends String> list){
        list.add(111);
        list.add("111");
        Object o = list.get(0);
        System.out.println(o);
    }

    public static void print2(List<? super String> list){
        list.add(111);
        list.add("111");
        Object o = list.get(0);
        System.out.println(o);
    }

    public static void print3(List<?> list){
        list.add(111);
        list.add("111");
        Object o = list.get(0);
        System.out.println(o);
    }
}
