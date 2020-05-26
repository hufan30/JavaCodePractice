package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/264:33 下午
 **/
public class JDKProxyImpl implements JDKProxyDemo {
    @Override
    public void sayA() {
        System.out.println("A");
    }

    @Override
    public void sayB() {
        System.out.printf("B");
    }
}

class JDKProxyHandle implements InvocationHandler{
    private JDKProxyDemo jpi;

    public JDKProxyHandle(JDKProxyDemo jpi) {
        this.jpi = jpi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKProxyDemo");
        //注意下面这里没有用上proxy，而是用上了自己定义的内部对象，jpi;
        return method.invoke(jpi,args);
    }
}
