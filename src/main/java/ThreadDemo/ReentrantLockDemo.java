package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private Lock bankLock = new ReentrantLock();
    private Condition banCon;

    public ReentrantLockDemo() {
        banCon = bankLock.newCondition();
    }

    public void transfer(int from, int to, int amount) {
        bankLock.lock();
        try {
            banCon.await();
            //doSomething;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }


}
