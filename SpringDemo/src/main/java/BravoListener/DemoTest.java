package BravoListener;

import org.junit.Before;
import org.junit.Test;

public class DemoTest {

    // 之所以设计成public static，是为了能在OrderService中拿到SmsService，毕竟我没实现Autowired自动注入
    public static BravoApplicationContext applicationContext;
    public static  SmsService smsService;
    public static OrderService orderService;
    public static CarService carService;

    @Before
    public void initApplicationContext() {
        applicationContext = new BravoApplicationContext();
        smsService =  (SmsService) applicationContext.getBean("BravoListener.SmsService");
        orderService = (OrderService) applicationContext.getBean("BravoListener.OrderService");
        carService = (CarService) applicationContext.getBean("BravoListener.CarService");
    }

    @Test
    public void testSpringEvent() {
        // 用户下单（试着点进去，把orderService发布的事件改为OtherEvent）
        orderService.order();
    }

}
