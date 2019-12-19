package EnumDemo;

public enum  Color1 {

    RED(0,"红色"),
BLUE(1,"这是蓝色"),
YELLOW(2,"这是黄色"),
GREEN(3,"这是绿色","lvse");

        //可以看出这在枚举类型里定义变量和方法和在普通类里面定义方法和变量没有什么区别。
        //唯一要注意的只是变量和方法定义必须放在所有枚举值定义的后面，否则编译器会给出一个错误。
        private int code;
private String desc;
private String desc1;

        public int getCode() {
return code;
}

public void setCode(int code) {
this.code = code;
}

public String getDesc() {
return desc;
}

public void setDesc(String desc) {
this.desc = desc;
}

public String getDesc1() {
return desc1;
}

public void setDesc1(String desc1) {
this.desc1 = desc1;
}


         Color1(int code,String desc){ //加上public void 上面定义枚举会报错 The constructor Color(int, String) is undefined
this.code=code;
this.desc=desc;

}

         Color1(int code,String desc,String desc1){
this.code=code;
this.desc=desc;
this.desc1=desc1;
}

        /**
  * 自己定义一个静态方法,通过code返回枚举常量对象
  * @param code
  * @return
  */
        public static Color1 getValue(int code){

for (Color1 color : values()) {
if(color.getCode()== code){
return color;
}
}
return null;
}


}