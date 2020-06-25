package LambardDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/1810:14 下午
 **/
public class AppleDemo {
    public static void main(String[] args) {
        List<Apple> apples = new LinkedList<>();
        apples.add(new Apple(3,"Red"));
        AppleDemo appleDemo = new AppleDemo();
        appleDemo.findRedApple3(apples);
    }


    public List<Apple> findBigApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            if (a.weight > 100) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Apple> findRedApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            if (a.color.equals("red")) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 不难发现上面两个方法有很多重复的，可以抽取成一个方法；
     * 这里方法中需要额外注入一个操作，判断，而不是通常只是注入一个数据，一个变量
     * 想到通过接口的方法；
     */
    interface 判断条件 {
        boolean 判断(Apple apple);
    }

    public List<Apple> findApple(List<Apple> apples, 判断条件 pd) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            if (pd.判断(a)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 这里通过匿名内部类的方式实现了，通过注入一个操作，或者说一个函数
     */
    public List<Apple> findBigApple2(List<Apple> apples) {
        return findApple(apples, new 判断条件() {
            @Override
            public boolean 判断(Apple apple) {
                return apple.weight>100;
            }
        });
    }

    /**
     * 这里通过函数式来实现Function，接受一个参数，返回一个结果
     */
    public List<Apple> findApple2(List<Apple> apples, Function<Apple,Boolean> ft) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            if (ft.apply(a)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 这里的实现的操作或者说函数是判断重量
     * @param apples
     * @return
     */
    public List<Apple> findBigApple3(List<Apple> apples) {
        return findApple2(apples,apple -> apple.weight>100);
    }

    /**
     * 这里实现的操作或者函数是判断颜色
     * @param apples
     * @return
     */
    public List<Apple> findRedApple3(List<Apple> apples){
        return findApple2(apples, apple -> apple.color.equals("Red"));
    }

    public void testLambda(){
        int i = 0;
        List<Apple> apples = Arrays.asList(new Apple(1,"Red"));
        findApple2(apples,apple ->{
//            i++;
        return  apple.color.equals("Red");});
    }

    public void a(){
        int a = 0;
        b(a);
    }
    public void b(int a){
        a++;
    }


}

class Apple {
    int weight;
    String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
