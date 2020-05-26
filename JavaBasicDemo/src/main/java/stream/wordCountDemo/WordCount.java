package stream.wordCountDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordCount {
    // 统计List中每个单词出现的次数
    // 例如，输入["aaa","bbb","ccc","aaa"]
    // 返回 { "aaa" -> 2, "bbb" -> 1, "ccc" -> 1 }
    public static Map<String, Integer> count(List<String> words) {
        return words.stream().collect(new WordCountCollector());
    }

    public static void main(String[] args) {
        System.out.println(count(Arrays.asList("a", "b", "c", "a", "b", "c", "d", "a")));
    }
}
