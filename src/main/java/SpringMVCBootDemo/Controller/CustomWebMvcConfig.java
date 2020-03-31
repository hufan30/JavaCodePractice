package SpringMVCBootDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/295:38 下午
 **/
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        RequestResponseBodyMethodProcessor handlerMethodArgumentResolver = (RequestResponseBodyMethodProcessor)process.getArgumentResolvers().stream()
//                .filter(p -> p instanceof RequestResponseBodyMethodProcessor)
//                .findFirst()
//                .get();
        resolvers.add(getHandlerMethodArgumentResolverDecorate());
    }

    @Bean
    public Controller.HandlerMethodArgumentResolverDecorate getHandlerMethodArgumentResolverDecorate(){
        return new Controller.HandlerMethodArgumentResolverDecorate();
    }
}



