package BeanPostProcessor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyAspectJAutoProxyCreatorTest {

    @Test
    public void testCalculPostCreator(){
        System.out.println("容器启动成功！");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAspectJAutoProxyCreator.AppConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //打印当前容器所有BeanDefinition
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("============");

        //取出Calculator类型的实例，调用add方法
        Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);
        calculator.add(1, 2);
    }

}