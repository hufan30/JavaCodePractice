package ThreadDemo;

public class ThreadLocalDemo {
    //1.定义threadlocal
    //2.写main方法，调用thread类
    //3.自定义thread类，覆盖run方法
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextnum() {
        threadLocal.set(threadLocal.get() + 1);
        return threadLocal.get() ;
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        ThreadTest threadTest1 = new ThreadTest(threadLocalDemo);
        ThreadTest threadTest2 = new ThreadTest(threadLocalDemo);
        ThreadTest threadTest3 = new ThreadTest(threadLocalDemo);

        threadTest1.start();
        threadTest2.start();
        threadTest3.start();

        System.out.println(threadLocalDemo.getNextnum());
        System.out.println(threadLocalDemo.getNextnum());
        System.out.println(threadLocalDemo.getNextnum());
    }

    private static class ThreadTest extends Thread {
        private ThreadLocalDemo t;

        public ThreadTest(ThreadLocalDemo threadLocalDemo) {
            this.t = threadLocalDemo;
        }

        @Override
        public void run() {
            for(int i=0;i<3;i++){
                System.out.println("Thread:"+Thread.currentThread()+"  "+t.getNextnum());
            }
        }
    }
}
