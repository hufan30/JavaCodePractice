package LambardDemo;

import java.util.function.BiFunction;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/212:42 下午
 **/
public class OperatorEnumDemo {
    public static int Calcute(Operator op, int x, int y) {
        switch (op) {
            case ADD:
                return x + y;
            case MINAL:
                return x - y;
            case MUTILE:
                return x * y;
            default:
                return x;
        }
    }

    public static int Calcute2(Operator2 op2, int x, int y) {
        return op2.Calcute(x, y);
    }
}

enum Operator {
    ADD, MINAL, MUTILE
}

/**
 * 这里Operator2是枚举，枚举中的就是对象，所以这里用构造器；
 */
enum Operator2 {
    ADD((x, y) -> x + y),
    MINAL((x, y) -> x - y),
    MUTILE((x, y) -> x * y);

    Operator2(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    BiFunction<Integer, Integer, Integer> function;

    public int Calcute(int x, int y) {
        return this.function.apply(x, y);
    }
}