package com.SpringMVCBootDemo.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/295:38 下午
 **/
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        RequestResponseBodyMethodProcessor handlerMethodArgumentResolver = (RequestResponseBodyMethodProcessor)process.getArgumentResolvers().stream()
//                .filter(p -> p instanceof RequestResponseBodyMethodProcessor)
//                .findFirst()
//                .get();
        resolvers.add(getHandlerMethodArgumentResolverDecorate());
    }

    @Bean
    public HandlerMethodArgumentResolverDecorate getHandlerMethodArgumentResolverDecorate(){
        return new HandlerMethodArgumentResolverDecorate();
    }
}



