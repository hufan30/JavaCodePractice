package SpringMVCBootDemo.Controller;

import SpringMVCBootDemo.Service.Service;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.lang.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/2710:44 上午
 **/
@org.springframework.stereotype.Controller
@RequestMapping("/demo")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public void hello(@RequestBody List<String> param) {
        service.sayHello();
    }

    @RequestMapping("/hello2")
    public void hello2(@myRequestBody List<String> param) {
        service.sayHello();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface myRequestBody {
    }

}




