package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/258:35 上午
 **/
public class flatMapDemo {
    public static void main(String[] args) {
        a();
        b();
    }

    public static void a() {
        String[] words = new String[]{"Hello", "World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
    }

    public static void b() {
        String[] words = new String[]{"Hello", "World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Stream::of)
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
    }
}
