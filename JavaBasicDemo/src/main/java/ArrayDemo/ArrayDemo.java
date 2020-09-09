package ArrayDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 016322522
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] intDemo1 = new int[3];
        int[] intDemo2 = new int[]{1, 2, 3};
        String[] stringDemo1 = new String[]{"1", "2", "234"};
        for (int i = 0; i < intDemo1.length; i++) {
            System.out.println(intDemo1[i]);
        }
        System.out.println("------------");
        for (int i = 0; i < intDemo2.length; i++) {
            System.out.println(intDemo2[i]);
        }
        System.out.println("--------stringDemo--------");
        for (int i = 0; i < stringDemo1.length; i++) {
            System.out.println(stringDemo1[i]);
        }

        List listDemo = new ArrayList();

        /**
         * 下面这种是不行的，数组是固定长度的
         */
        int[] intDemo3 = new int[]{};
        intDemo3[0] = 1;
    }
}
