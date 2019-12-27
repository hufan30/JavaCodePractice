package MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo implements BiConsumer {

    private static Map<Integer, Integer> counts = new HashMap();
    static {
        counts.put(1, 1);
        counts.put(2, 2);
    }

    /**
     * 测试forEach，顺便又练习了一下函数式接口的lambda的表达式
     */
    public void forEachTest1(){
        counts.forEach((k,v)->{
            if(k.equals(1))
                System.out.println("这是1");
        });
    }

    /**
     * 从函数式接口的原始方式出发，接口当然是需要实现了，直接用当前类implements接口，然后
     * 覆写了抽象方法；
     */
    public void forEachTest2(){
        counts.forEach(this::accept);
    }

    /**
     * 验证iterator的特性，注意到集合中map是没有实现iterator接口的
     * 所以没有办法直接使用map.iterator
     * 但是可以通过map.entryset.iterator来使用
     * 本质是set，散列是实现了iterator接口的；
     * map是映射，区分是不一样的
     */
    public void mapIterator(){
//        counts.iterator();
        counts.entrySet().iterator();
    }

    public static void main(String[] args) {
        MapDemo md = new MapDemo();
        md.forEachTest1();
        md.forEachTest2();
    }

    @Override
    public void accept(Object o, Object o2) {
        System.out.println("覆盖");
    }
}
