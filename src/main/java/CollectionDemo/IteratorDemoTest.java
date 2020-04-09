package CollectionDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/4/910:11 下午
 **/
public class IteratorDemoTest {
    public static void main(String[] args) {
        List a = Arrays.asList(1,2,3);
        a.forEach(System.out::println);
    }
}
