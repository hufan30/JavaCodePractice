package ClassLoaderDemo;

import stream.Problem1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/911:00 下午
 **/
public class ClassLoader1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
//        Class c1 = Problem1.class;
        Class c2 = new myClassLoader().loadClass("stream.Problem1");
        Object o = c2.getConstructor().newInstance();
        Problem1 p1 = (Problem1)o; //这里会报无法cast的异常，这是因为类名+classloader才是唯一确定一个实例的根据；
        System.out.println();

        ClassLoader c3 = ClassLoader1.class.getClassLoader();
        c3.loadClass("java.util.stream.Stream");

        DriverManager.getConnection("");
    }
}

class myClassLoader extends ClassLoader {
    public myClassLoader() {
    }

    public myClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("Problem1")) {
            try {
                byte[] bytes = Files.readAllBytes(new File("target/classes/stream/Problem1.class").toPath());
                return defineClass(name,bytes,0,bytes.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        } else {
            return super.loadClass(name);
        }
    }
}

