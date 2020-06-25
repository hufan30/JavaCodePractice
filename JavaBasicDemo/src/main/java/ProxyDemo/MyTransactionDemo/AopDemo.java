package ProxyDemo.MyTransactionDemo;

import ProxyDemo.MyTransactionDemo.Factory.MyBeanFactory;

public class AopDemo {
    public static void main(String[] args) {
        MyBeanFactory beanFactory = new MyBeanFactory();
        try{
            Object bean = beanFactory.getBean("com.SpringBootJDKDemo.UserServiceIml");
            System.out.println(bean.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
