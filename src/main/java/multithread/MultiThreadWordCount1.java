package multithread;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadWordCount1 {
    // 使用threadNum个线程，并发统计文件中各单词的数量
    public static Map<String, Integer> count(int threadNum, List<File> files) throws IOException, InterruptedException {
        Map<String, Integer> result = new ConcurrentHashMap<>();
        AtomicInteger restFileNumber = new AtomicInteger(files.size());
        for (File file : files) {
            new Thread(() -> {
                try {
                    Map<String, Integer> countResult = Utils.countFile(file);
                    synchronized (result) {
                        //这里使用merge到第一个result中，是因为runable没有返回值；
                        Utils.mergeIntoFirstMap(result, countResult);
                        if (restFileNumber.decrementAndGet() == 0) {
                            result.notify();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
/*                    不能“打印一下异常，然后若无其事地继续程序，就好像什么都没发生过一样”。打印的异常很容易被忽略，
                      这样做是给以后挖坑。在多线程的环境下尤其要注意，因为异常的抛出是违反直觉的。
                      应该把其他线程中的异常收集到一起，最后检查异常，若有则抛出异常*/
                    throw new RuntimeException(e);  //至少这样向上抛一个；
                }
            }).start();
        }

        synchronized (result) {
            while (restFileNumber.intValue() > 0) {
                result.wait();
            }
        }

        return result;
    }
}
