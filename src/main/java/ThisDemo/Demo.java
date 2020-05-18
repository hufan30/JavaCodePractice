package ThisDemo;

public class Demo {

    public static void main(String[] args) {
        /**
         * new一个子类对象
         * 我们知道，子类对象实例化时，会隐式调用父类的无参构造
         * 所以Father里的System.out.println()会执行
         * 猜猜打印的内容是什么？
         */
        Son son = new Son();

        Daughter daughter = new Daughter();
    }

}
class Granda {
    public Granda(){
        /**
         * 即使是构造器调用向上传递到grandpa，打印出来的还是son;
         * 这里涉及到this的传递，一直构造器super向上传递的this是son的；
         */
        System.out.println(this.getClass().getName());
    }
}

class Father extends Granda{
    /**
     * 父类构造器
     */
    public Father(){
        // 打印当前对象所属Class的名字
        System.out.println(this.getClass().getName());
    }
}

class Son extends Father {
    Son() {
        // 显示调用父类无参构造
        super();
    }
}

class Daughter extends Father {
}
