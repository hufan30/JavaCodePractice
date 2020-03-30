package ClassLoaderDemo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/178:11 下午
 **/
public class HotSwap {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int byteslength = 0;
        byte[] bytes = Files.readAllBytes(new File("target/classes/ClassLoaderDemo/MyApp.class").toPath());
        if (byteslength != bytes.length) {
            Class<?> cl = new HotSwapClassLoader().loadClass("ClassLoaderDemo.MyApp");
            Method meth = cl.getMethod("main", String[].class);
            String[] params = null; // init params accordingly
            new Thread(()-> {
                try {
                    meth.invoke(null, (Object) params);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }).start();

            
        }
    }
}

class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
    }

    public HotSwapClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("MyApp")) {
            try {
                byte[] bytes = Files.readAllBytes(new File("target/classes/ClassLoaderDemo/MyApp.class").toPath());
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        } else {
            return super.loadClass(name);
        }
    }
}
