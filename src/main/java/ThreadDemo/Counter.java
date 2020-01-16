package ThreadDemo;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/1610:27 下午
 **/

public class Counter {

    private static int x = 0;

    // 计数方法
//    public void count() {
//        for (int i = 0; i <= 10; i++) {
//            x = x + i;
//        }
//        System.out.println(Thread.currentThread().getName() + "--" + x);
//    }

    public static void main(String[] args) {
        int value = 0;
        // 定义线程实现接口
        Runnable runnable = new Runnable() {
            Counter counter = new Counter();

            @Override
            public void run() {
//                counter.count();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x++;
                System.out.println(x);

//                value++;

                // 这里就很奇怪了，为什么value会编译错误，而上面的x++就不报错；
                //这里简要的谈谈自己的初步理解，因为static和定义的范围，首先需要注意的是x是定义在最外面类中的，而且是可以用static修饰的；
                //但是类中方法，即使是static方法，比如这里的main方法，里面也是不允许用static修饰的；
                //初步想的是static修饰的成员变量和成员方法的，这是相对最外面的本类来说的，所以static方面里面也不允许有static变量；
                //注意说的是成员变量，你在方法中的变量，本身就是这个方法的局部变量了啊！！！！！
                //这里的x本质上是一个全局的共享变量，而value是本方法，main方法中的局部变量；
                //x已经是static，是全局的了，所以不会存在被提前销毁的顾虑；
                //而value是在本方法中定义的，
                //局部变量存在于栈帧的局部变量表中，一旦方法结束，栈帧被销毁，这个变量（这份数据）就不再存在，
                // 但是匿名内部类中的value可能在栈帧销毁后继续存在（比如在这个例子中，匿名内部类被提交到了线程池中）。
                //这里主要是因为对于方法中的变量本身就是这个方法的局部变量这个点的没有形成条件反射，还在考虑一个变量是怎么划分为全局变量和线程的局部变量的问题；
            }
        };
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        System.out.println("last:" + x);
    }

    public static void doSomething() {
        int value = 0;
        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
//                value++;
                x++;
            }
        });
    }

    public static class test {

    }

}

