package ThreadDemo;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/1610:14 下午
 **/
public class AtomicIntegerDemo {

    /**
     * 这里传入的AtomicInteger实际在线程中还是被改变了值；
     * 一开始又有点混淆了，说传入的实际上应该是线程自己拷贝的值，线程中指向的地址和
     * @param args
     */
    public static void main(String[] args) {
        BlockingQueue<Future> queue = new LinkedBlockingQueue<>(10);

        AtomicInteger ai = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int temp = new Random().nextInt();
                ai.addAndGet(temp);
            }
            ).start();
        }

        System.out.println(ai.get());
    }
    


}
