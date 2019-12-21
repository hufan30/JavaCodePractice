package EnumDemo;

import EnumDemo.Color;

public class EnumTest {

    public static void main(String[] args) {
        String str = Color.getValue(0).getDesc();
        System.out.println("测试枚举的values==" + str);

		/*测试枚举的valueof,里面的值可以是自己定义的枚举常量的名称
		       其中valueOf方法会把一个String类型的名称转变成枚举项，也就是在枚举项中查找字面值和该参数相等的枚举项。*/
        Color color = Color.valueOf("GREEN");
        System.out.println("valueOf==code===" + color.getCode());
        System.out.println("valueOf==desc===" + color.getDesc());

        //测试枚举的toString()方法
        Color s2 = Color.getValue(0);
        System.out.println("s2===" + s2);
        System.out.println("s2===" + s2.toString());
    }

}