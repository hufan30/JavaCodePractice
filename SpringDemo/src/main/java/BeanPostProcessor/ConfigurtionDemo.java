package BeanPostProcessor;

import org.springframework.context.annotation.Configuration;

/**
 * @author hufan
 * @date 2020/6/12 10:21 下午
 * @annotation
 */
@Configuration
public class ConfigurtionDemo {
    public void test(){
        System.out.println("类上加@Configuration，该类就自动注入容器");
        System.out.println("并且由于@Configuration，该类会被CGLIB代理，保证有且只有一个");
    }
}
