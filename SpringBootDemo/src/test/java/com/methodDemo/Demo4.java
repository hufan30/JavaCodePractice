package com.methodDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo4 {
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

        // 给女嘉宾发牌子
        Map<Integer, Couple> wivesMap = new HashMap<>();
        for (Couple wife : wives) {
            // 女嘉宾现在不在List里了，而是去了wivesMap中，前面放了一块牌子：男嘉宾的号码
            wivesMap.put(wife.getFamilyId(), wife);
            count++;
        }

        // 男嘉宾上场
        for (Couple husband : husbands) {
            // 找到举着自己号码牌的女嘉宾
            Couple wife = wivesMap.get(husband.getFamilyId());
            System.out.println(husband.getUserName() + "爱" + wife.getUserName());
            count++;
        }

        System.out.println("----------------------");
        System.out.println("循环了：" + count + "次");
    }
}
