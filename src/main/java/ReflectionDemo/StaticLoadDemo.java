package ReflectionDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/172:39 下午
 **/
public class StaticLoadDemo {

    static{
        System.out.println("Main初始化");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /**
         * 1.加载到内存，会产生一个类对应class对象
         * 2.链接，链接结束后m=0；默认值
         * 3.初始化
         * <clinit>(){
         *     sout(A的静态代码块)；
         *     m=300;
         *     m=100;
         * }
         * 合并之后，m=100;
         */
    }
}

class A{
    static{
        System.out.println("A的静态代码块");
        m = 300;
    }
    static int m = 100;

    public A(){
        System.out.println("A的无参数构造");
    }
}