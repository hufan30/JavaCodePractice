package SpringMVCBootDemo.Controller;

import SpringMVCBootDemo.Service.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public void hello(@RequestBody Map<String,Object> param){
        service.sayHello();
    }
}
