package ForDemo;

import org.springframework.context.annotation.EnableMBeanExport;

import java.util.ArrayList;
import java.util.List;

public class forTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int b =1;
        for(Integer each:list){
            Integer a = 1;
            System.out.println(a);
        }
        list.add(1);
        /**
         * fori快捷键测试，快速生成循环
         * list.fori
         */
        for (int i = 0; i < list.size(); i++) {
            
        }
        /**
         * forr快捷键测试，快速生成倒循环
         * list.forr
         */
        for (int i = list.size() - 1; i >= 0; i--) {

        }

        /**
         * 测试xixi，自定义的快键键
         */
        String xixiTest;



    }
}
