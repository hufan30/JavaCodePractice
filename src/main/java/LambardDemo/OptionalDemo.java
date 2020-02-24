package LambardDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/248:40 下午
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        List<String> s = Arrays.asList("a", "b", "c");

        /**
         * 使用optional，找到list中第一个长度大于2的字符串
         */
        Optional<String> first = s.stream().filter(s1 -> s1.length() > 2).findFirst();
        System.out.println(first);

        String s2 = s.stream().filter(s1 -> s1.length() > 2).findFirst().orElseThrow(RuntimeException::new);
        System.out.println(s2);

        /**
         * java8之前的写法
         */
        String s1 = findFirstLengthAbove2(s);
        if (s1 == null) {
            throw new RuntimeException();
        } else {
            System.out.println(s1);
        }
    }

    /**
     * 找到列表中第一个长度大于2的字符串
     * @param S
     * @return
     */
    private static String findFirstLengthAbove2(List<String> S) {
        for (String s : S) {
            if (s.length() > 2) {
                return s;
            }
        }
        return null;
    }
}
