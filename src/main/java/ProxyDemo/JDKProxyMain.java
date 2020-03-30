package ProxyDemo;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/264:36 下午
 **/
public class JDKProxyMain {
    public static void main(String[] args) {
        JDKProxyDemo jpi = new JDKProxyImpl();
        JDKProxyHandle handle = new JDKProxyHandle(jpi);

        JDKProxyDemo proxy = (JDKProxyDemo) Proxy.newProxyInstance(jpi.getClass().getClassLoader(),new Class[]{JDKProxyDemo.class},handle);
        //这里测试是不是接口方法，一代理，全代理，是的；
        proxy.sayA();
        proxy.sayB();
    }
}
