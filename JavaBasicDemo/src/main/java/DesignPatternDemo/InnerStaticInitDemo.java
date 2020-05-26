package DesignPatternDemo;

/**
 * @description: 静态内部类的单例模式
 * @author: HuFan
 * @time: 2020/5/2210:38 下午
 **/
public class InnerStaticInitDemo {
    private static class InnerInstance {
        private static InnerStaticInitDemo innerStaticInitDemo = new InnerStaticInitDemo();
    }

    private InnerStaticInitDemo() {
    }

    public static InnerStaticInitDemo getInnerStaticDemo(){
        return InnerInstance.innerStaticInitDemo;
    }

}
