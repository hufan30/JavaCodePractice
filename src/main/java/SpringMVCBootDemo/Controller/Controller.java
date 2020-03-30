package SpringMVCBootDemo.Controller;

import SpringMVCBootDemo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.lang.annotation.*;
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
    public void hello(@RequestBody Map<String,Object> param){
        service.sayHello();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface myRequestBody {
    }

    //装饰器模式，不是说你实现了原始接口方法就好了，虽然这里有两个方法，但是要让其参与到Springboot框架中，还有很多其他代码；
    //自己从头写一遍没有必要，要原先调试时发现的那个实现类，引入，调用它的方法，然后装饰
    //这里最直接的就是resolveArgument,里面先是调用内部实现类，然后装饰上自己的instanceof Map,是就是放入一个时间戳；

    /**
     * 这里自定义的myRequestBody注解想要起作用，首先需要方法参数解析器来解析自定义的注解
     * 但是自定义来一个新的方法参数解析器，它怎么参与到Springboot框架呢？
     * 又来一层，俄罗斯套娃，就需要WebMvcConfigurer中addaddArgumentResolvers方法；
     * 将自定义的方法参数解析器加进去；
     */
    public static class HandlerMethodArgumentResolverDecorate implements HandlerMethodArgumentResolver{
        private RequestResponseBodyMethodProcessor delegate;

        public HandlerMethodArgumentResolverDecorate(RequestResponseBodyMethodProcessor rp) {
            delegate = rp;
        }

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.hasParameterAnnotation(myRequestBody.class);
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            Object result = delegate.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
            if(parameter instanceof Map){
                ((Map) parameter).put("TimeStamp", System.currentTimeMillis());
            }
            return result;
        }
    }

}




