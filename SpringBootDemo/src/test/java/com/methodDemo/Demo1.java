package com.methodDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

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
                }
            }
        }

        System.out.println("----------------------");
        System.out.println("循环了：" + count + "次");
    }
}

@Data
@AllArgsConstructor
class Couple {
    private Integer familyId;
    private String userName;
}
