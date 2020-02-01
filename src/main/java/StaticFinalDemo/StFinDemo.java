package StaticFinalDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2019/12/217:51 下午
 **/
public class StFinDemo {
    private static List<Integer> stL = new ArrayList<Integer>();
    private final List<Integer> finL = new ArrayList<Integer>();
    private static final List<Integer> stfinL = new ArrayList<>();
    String s = "hello";

    public static List<Integer> getStL() {
        return stL;
    }

    private static void setStL(int i) {
        stL.add(i);
    }

    public List<Integer> getFinL() {
        return finL;
    }

    public static List<Integer> getStfinL() {
        return stfinL;
    }

    public static void main(String[] args) {
        StFinDemo sf1 = new StFinDemo();
        sf1.finL.add(1);
        setStL(1);
        stfinL.add(1);
        System.out.println(stL);
        StFinDemo sf2 = new StFinDemo();
    }

    public static class Inner{
        static int i = 1; //static内部类中可以有static；
    }
}
