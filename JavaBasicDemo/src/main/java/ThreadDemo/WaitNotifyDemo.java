package ThreadDemo;

import java.util.Random;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/107:32 下午
 **/
public class WaitNotifyDemo {


    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();

        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        producer.start();
        consumer.start();

        producer.join();
//        consumer.join();
    }

    static class Container {
        Object value;
    }

    static class Producer extends Thread {

        Container container;

        public Producer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {

            synchronized (container) {
                for (int i = 0; i < 10; i++) {
                    while (container.value != null) {
                        try {
                            container.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = new Random().nextInt();
                    System.out.println("Producer:" + value);
                    container.value = value;
                    container.notify();
                }
            }
        }
    }

    static class Consumer extends Thread {

        Container container;

        public Consumer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {

            synchronized (container) {
                for (int i = 0; i < 10; i++) {
                    while (container.value == null) {
                        try {
                            container.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consumer:" + container.value);
                    container.value = null;
                    container.notify();
                }
            }
        }
    }
}
