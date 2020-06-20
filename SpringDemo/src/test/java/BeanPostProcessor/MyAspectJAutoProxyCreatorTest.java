package BeanPostProcessor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyAspectJAutoProxyCreatorTest {

    @Test
    public void testCalculPostCreator(){
        System.out.println("容器启动成功！");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAspectJAutoProxyCreator.AppConfig.class);
        /**
         * 这里要冷静思考，为什么aop最开始没起作用,第一个猜测是没有注入到容器中；
         * 但是下面的容器的打印beanDefinitionNames中是有aop的；
         * 那么就是spring还有什么没有开启，比如在xml文件中开启；
         * 或者是在注解中开启@EnableAspectJAutoProxy；
         */

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //打印当前容器所有BeanDefinition
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("============");

        //取出Calculator类型的实例，调用add方法
        Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);
        calculator.add(1, 2);

        ConfigurtionDemo configurtionDemo = (ConfigurtionDemo) applicationContext.getBean("configurtionDemo");
        configurtionDemo.test();
    }

}