package ProxyDemo;

import java.lang.reflect.*;

public class CalculatorProxy {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.通过getProxy()获得类
        /**
         * Proxy.getProxyClass()这个方法的本质就是：以Class造Class。
         * 以什么class造什么class，用接口的class来造一个Proxy.class；从方法名也能看出来嘛，getProxyClass；
         */
        Class<?> calProxy = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        /**
         * 造出来的Proxy.class对象，里面有一个默认空构造方法，有一个带InvocationHandler的构造方法；
         * 通过class的getConstructor来获得这个方法；
         */
        Constructor<?> calProxyConstructor = calProxy.getConstructor(InvocationHandler.class);

        Calculator calInstance = (Calculator) calProxyConstructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

    }
}
