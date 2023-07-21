package DesignPatternDemo;

import com.beust.jcommander.internal.Lists;

import java.util.List;

/**
 * @description: 饿汉式的简单实例，大部分生产中该方式即可满足需求
 * @author: HuFan
 * @time: 2020/5/2210:34 下午
 **/
public class InitDemo {
    public static InitDemo initDemo = new InitDemo();

    private InitDemo() {
        List<Object> objects = Lists.newArrayList();
        objects.clear();

    }

    public static class InnerTest{} //静态内部类，才能在main方法里new

    public static InitDemo getInitDemo() {
        return initDemo;
    }
}
