package SpringMVCBootDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/295:38 下午
 **/
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    RequestResponseBodyMethodProcessor rp;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new Controller.HandlerMethodArgumentResolverDecorate(rp));
    }
}



