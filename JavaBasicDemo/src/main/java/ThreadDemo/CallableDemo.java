package ThreadDemo;

import java.util.concurrent.*;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/11:56 下午
 **/
public class CallableDemo {

    static Callable ca = new Callable() {
        @Override
        public Object call() throws Exception {
            return 1;
        }
    };

    //Thread里面不能放Callable对象
//    Thread t1 = new Thread(ca);
    //这样不是callable的正确用法，应该是如同main方法里面写的那样
    //先用FutureTask包装，然后在new Thread；
    //或者用线程池的threadpool.submit



    public static void main(String[] args) {


        //先使用Lambda表达式创建Callable<Integer>对象，
        //并使用FutureTask来包装Callable对象
        FutureTask ft = new FutureTask(()-> 1);
        Thread t1 = new Thread(ft);
        t1.start();

        try {
            System.out.println(ft.get());   //还是需要从futuretask里面拿到call的返回值
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //线程池的例子；
        ExecutorService es = Executors.newCachedThreadPool();
        Future ft2 = es.submit(ca);//相当于start
//        Future ft3 = es.submit((new Callable()) ()->{return 1;} ); //错误的lambda表达式，只需要传递进去一个方法体就行，不需要new一个


        Future ft4= es.submit((Callable<Integer>)()->{return 1;}); //相当于start

        try {
            System.out.println(ft2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
