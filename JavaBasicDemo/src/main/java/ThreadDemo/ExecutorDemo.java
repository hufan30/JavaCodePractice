//package ThreadDemo;
//
//import sun.applet.AppletThreadGroup;
//
//import java.util.concurrent.*;
//
///**
// * @description:
// * @author: HuFan
// * @time: 2020/1/303:38 下午
// **/
//public class ExecutorDemo {
//
//    public static void main(String[] args) {
//        MyExecutor myExecutor = new MyExecutor();
//
//        myExecutor.execute(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("myExecutor1");
//        });
//
//
//        //阿里规范，使用线程池
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 60,
//                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (runnable) ->
//                new Thread(runnable, "ThreadPool"),
//                new ThreadPoolExecutor.DiscardPolicy());
//
//        //进一步个性化定制，使用Dameon和setUncaughtExceptionHandler
//        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(3, 3, 60,
//                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (runnable) ->{
//            Thread threadPool = new Thread(runnable, "ThreadPool");
//            threadPool.setDaemon(true);
//            //这里只是临时用了一个uncaughtExceptionHandler
//            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new AppletThreadGroup("1");
//            threadPool.setUncaughtExceptionHandler(uncaughtExceptionHandler);
//            return threadPool;
//        }, new ThreadPoolExecutor.DiscardPolicy());
//
//    }
//
//    public static class MyExecutor implements Executor {
//
//        @Override
//        public void execute(Runnable command) {
//            new Thread(command).start();
//        }
//    }
//}
