package LambardDemo;

import java.awt.event.ActionListener;

/**
 * @description:
 * @author: HuFan
 * @time: 2019/12/216:59 下午
 **/
public class repeatLambda {
    //这里lambda捕获的就是非参数的自由变量，注意finalI不是lambda表达式的参数，不是传参数传进去的，所以结合书上说的是要捕获这个变量，闭包的说法；
    //或者说让其隐形的变成final变量；
    //这样做的原因是因为外面变量有可能在lambda还没执行的时候，就已经销毁了，所以这里是编译器会检查
    public static void repeat1(String text, int count) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            ActionListener listener = event -> System.out.println(finalI + ":" + text);
//            finalI = 7;
        }
    }

    public static void repeat2(int n, Intcousumer intcousumer) {
        for (int i = 0; i < n; i++) intcousumer.accept(i);
    }

    //注意这里lambda虽然和上面长得很像，但是这里不是捕获外部变量了，这里的i是lambda的参数，是变成了lambda自己的本地变量了
    public static void main(String[] args) {
        repeat2(10, i -> System.out.println(i + ":")
        );
    }
}

interface Intcousumer {
    void accept(int value);
}