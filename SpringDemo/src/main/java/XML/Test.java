package XML;

import BeanPostProcessor.MyAspectJAutoProxyCreator;
import Config.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // 由于是XML配置方式，对应的Spring容器是ClassPathXmlApplicationContext,传入配置文件告知Spring去哪读取配置信息
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        // 从容器中获取Person-
        //setter注入
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //constructor注入，这里是在xml中，利用person类定义两个bean，不同id而已；
//        Person person2 = (Person) applicationContext.getBean("person2");
//        System.out.println(person2);
    }
}