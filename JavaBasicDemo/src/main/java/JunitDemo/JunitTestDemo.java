package JunitDemo;

public class JunitTestDemo {

    @OnceBefore
    public void initOnce() {
        System.out.println("只初始化一次...");
    }

    @OnceAfter
    public void destoryOnce() {
        System.out.println("只销毁一次...");
    }

    @MyBefore
    public void init() {
        System.out.println("当前方法初始化1...");
    }
//    @MyBefore
//    public void init2() {
//        System.out.println("初始化2...");
//    }

    @MyAfter
    public void destroy() {
        System.out.println("当前方法销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
}
