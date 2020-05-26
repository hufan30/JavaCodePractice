package ThreadDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/2010:59 下午
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        ConcurrentHashMap result = new ConcurrentHashMap();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);

        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int temp = new Random().nextInt();
                result.put(temp, temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cyclicBarrier.await();
        System.out.println(result);
    }
}
