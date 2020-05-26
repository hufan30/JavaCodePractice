package ProxyDemo.MyTransactionDemo.Factory;

import ProxyDemo.MyTransactionDemo.Annotation.MyTransactional;
import ProxyDemo.MyTransactionDemo.utils.ConnectionUtils;
import ProxyDemo.MyTransactionDemo.utils.MyTransactionManager;

public class MyBeanFactory {
    public Object getBean(String name) throws Exception {
        //得到目标类的Class对象
        Class<?> clazz = Class.forName(name);
        //得到目标对象
        Object bean = clazz.newInstance();
        //得到目标类上的@MyTransactional注解
        MyTransactional myTransactional = clazz.getAnnotation(MyTransactional.class);
        //如果打了@MyTransactional注解，返回代理对象，否则返回目标对象
        if (null != myTransactional) {
            MyProxyFactoryBean proxyFactoryBean = new MyProxyFactoryBean();
            MyTransactionManager txManager = new MyTransactionManager();
            txManager.setConnectionUtils(new ConnectionUtils());
            //装配通知和目标对象
            proxyFactoryBean.setTxManager(txManager);
            proxyFactoryBean.setTarget(bean);
            Object proxyBean = proxyFactoryBean.getProxy();
            //返回代理对象
            return proxyBean;
        }
        //返回目标对象
        return bean;
    }
}
