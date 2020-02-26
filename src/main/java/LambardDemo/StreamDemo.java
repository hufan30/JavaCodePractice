package LambardDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/268:57 上午
 **/
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "this is a apple", "ABC", "ABCD","");

        /**
         * java8之前想要获得这个list中大写字母开头的单词个数
         */
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            String[] split = word.split("//s");
            for (String s : split) {
                if (!s.isEmpty() && Character.isUpperCase(s.charAt(0))) {
                    int count = map.getOrDefault(s, 0) + 1;
                    map.put(s, count);
                }
            }
        }
        map.entrySet();

        /**
         * java8之后可以考虑流处理
         */
        Map<String, Long> collect1 = list.stream().filter(word -> !word.isEmpty()).filter(word -> Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map<String, Long> collect = list.stream().map(x -> x.split("//s"))
                .flatMap(Stream::of)
                .filter(word -> !word.isEmpty()).filter(word -> Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println();

    }
}
