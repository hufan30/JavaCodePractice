package ThreadDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2019/12/238:47 下午
 **/
public class ThreadDemo {
    Runnable a = () -> System.out.println(123);

    //线程中创建的对象，是每个线程私有的；
    //但是这个a,是公有的；
    public static void main(String[] args) {
        Apple a = new Apple();

        for(int i=0;i<4;i++){
            new Thread(()->{
                System.out.println(new Apple());
                System.out.println(Thread.currentThread());
                System.out.println(a);
            }).start();
        }
    }
}
class Apple{

}