package ThreadDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/1/22:45 下午
 **/
public class ThreadPoolDemo {

    ExecutorService es = Executors.newCachedThreadPool();

    public void threadPoolTest(){
        Future<Integer> submit = es.submit(() -> 1);
    }
}
