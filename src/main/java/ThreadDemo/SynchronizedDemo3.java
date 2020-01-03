package ThreadDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/39:18 下午
 **/

import java.util.concurrent.CountDownLatch;

/**
 * Created by sxb-gt on 2018/1/21.
 * “主线程类”注意：该类并没有集成Thread。只是为了形象，才取的这个名字。
 */
public class SynchronizedDemo3 {
    private Integer i = 0;
    /** 线程计数器 **/
    private CountDownLatch count;
    public CountDownLatch getCount() {
        return count;
    }
    public void setCount(CountDownLatch count) {
        this.count = count;
    }
    public  void add() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + "执行开始");
        synchronized(i) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(i);
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "执行结束");
    }

    public static void main(String[] args) {
        System.out.println("主线程执行开始");
        SynchronizedDemo3 mainThread = new SynchronizedDemo3();
        int length = 3;
        mainThread.setCount(new CountDownLatch(length));
        for (int i = 0; i < length; i++ ) {
            Thread thread = new AssistantThread(mainThread);
            thread.start();
        }
        try {
            mainThread.getCount().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i===" + mainThread.i);
        System.out.println("主线程执行结束");
    }
}

class AssistantThread extends Thread {
    private SynchronizedDemo3 mainThread;

    public AssistantThread(SynchronizedDemo3 mainThread) {
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        mainThread.add();
        mainThread.getCount().countDown();
    }
}
