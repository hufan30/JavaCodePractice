package AbstractDemo;

/**
 * @description: 抽象类的实验
 * @author: HuFan
 * @time: 2020/5/2710:35 下午
 **/
public abstract class AbstractDemo {
    public abstract void testAbstract();

    public void testNonAbstract() {
    }

    //抽象类一样可以有构造函数
    public AbstractDemo() {
    }

    public static void main(String[] args) {
        //抽象类一样构造new，只是需要先实现它的抽象方法
        AbstractDemo abstractDemo = new AbstractDemo() {
            @Override
            public void testAbstract() {

            }
        };
        NonAbstract nonAbstract = new NonAbstract();
        NonAbstract sonNonAbstract = new SonNonAbstract();
        NonAbstract nonAbstract匿名内部 = new NonAbstract() {
        };
        System.out.println(123);
    }
}

class NonAbstract {

}

class SonNonAbstract extends NonAbstract {
}
