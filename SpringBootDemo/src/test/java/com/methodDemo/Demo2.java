package com.methodDemo;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {

        // 用于计算循环次数
        int count = 0;

        // 老公组
        List<Couple> husbands = new ArrayList<>();
        husbands.add(new Couple(1, "梁山伯"));
        husbands.add(new Couple(2, "牛郎"));
        husbands.add(new Couple(3, "干将"));
        husbands.add(new Couple(4, "工藤新一"));
        husbands.add(new Couple(5, "罗密欧"));

        // 老婆组
        List<Couple> wives = new ArrayList<>();
        wives.add(new Couple(1, "祝英台"));
        wives.add(new Couple(2, "织女"));
        wives.add(new Couple(3, "莫邪"));
        wives.add(new Couple(4, "毛利兰"));
        wives.add(new Couple(5, "朱丽叶"));

        for (Couple husband : husbands) {
            for (Couple wife : wives) {
                // 记录循环的次数
                count++;
                if (husband.getFamilyId().equals(wife.getFamilyId())) {
                    System.out.println(husband.getUserName() + "爱" + wife.getUserName());
                    // 牵手成功，把女嘉宾从舞台请下来，同时换下一位男嘉宾上场
                    wives.remove(wife);
                    break;
                }
            }
        }

        System.out.println("----------------------");
        System.out.println("循环了：" + count + "次");
    }
}
