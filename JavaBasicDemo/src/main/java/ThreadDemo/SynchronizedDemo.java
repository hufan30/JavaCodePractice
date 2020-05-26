package ThreadDemo;

public class SynchronizedDemo {

    public synchronized void transfer(int from,int to ,int amount) throws InterruptedException {
        wait();
        //doSomething;
        notifyAll();

    }

}
