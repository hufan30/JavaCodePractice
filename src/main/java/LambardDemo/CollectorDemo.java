package LambardDemo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/279:09 下午
 **/
public class CollectorDemo {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "bb", "ccc");

        List<Integer> list = new ArrayList<>();
        BiConsumer<List<Integer>, Integer> biConsumer2 = List::add;

        //传统方法
        strings.stream().map(x -> x.length()).forEach(x -> biConsumer2.accept(list, x));
        System.out.println(list);
        List<Integer> collect = strings.stream().map(x -> x.length()).collect(Collectors.toList());
        System.out.println(collect);

        //使用自己编写的Mycollector,完成统计字符串列表中字符串长度
        List collect1 = strings.stream().map(String::length).collect(new MyCollector());
        System.out.println(collect1);
    }
}

class MyCollector implements Collector<Integer, List, List> {
    //首先需要创建返回的类型
    @Override
    public Supplier<List> supplier() {
        return ArrayList::new;
    }

    //然后是如何进行消费的,当然可以直接使用List::add
    @Override
    public BiConsumer<List, Integer> accumulator() {
        return (list, number) -> list.add(number);
    }

    @Override
    public BinaryOperator<List> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List, List> finisher() {
        return x->x;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
