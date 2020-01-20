package ThreadDemo;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/2010:59 下午
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap result = new ConcurrentHashMap();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int temp = new Random().nextInt();
                result.put(temp, temp);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(result);
    }
}
