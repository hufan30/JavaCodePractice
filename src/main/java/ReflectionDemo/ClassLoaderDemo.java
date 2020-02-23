package ReflectionDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/173:40 下午
 **/
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        System.out.println(c1);
        //获取系统类加载器的父类，扩展类加载器
        ClassLoader c1Parent = c1.getParent();
        System.out.println(c1Parent);
        //获取扩展类加载器的父类，根加载器
        ClassLoader c1root = c1Parent.getParent();
        System.out.println(c1root);

        //获取本地类的加载器，即系统类加载器
        ClassLoader c2 = Class.forName("ReflectionDemo.ClassLoaderDemo").getClassLoader();
        System.out.println(c2);

        //获取核心类的加载器，即根加载器，无法直接拿到
        ClassLoader c3 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(c3);

        //获取系统类加载器的加载路径path
        System.out.println(System.getProperty("java.class.path"));
    }


}
