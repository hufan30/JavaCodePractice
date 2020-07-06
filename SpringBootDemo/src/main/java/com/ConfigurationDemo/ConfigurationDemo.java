package com.ConfigurationDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hufan
 * @date 2020/7/5 4:28 下午
 * @annotation
 */
@Configuration
public class ConfigurationDemo {

    /**
     * 这里的student虽然会标红，但是仍到找到，因为student的bean是通过@Component加载的，这里idea没有识别到
     * 同理对比EurekaClient代码中的标红
     * 这里的@Bean会自动的从容器自动加载student的实现类
     * @param student
     * @return
     */
    @Bean
    public Teacher teacher(Student student){
        return new Teacher(student);
    }

}
