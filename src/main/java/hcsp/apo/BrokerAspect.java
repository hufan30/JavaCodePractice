package hcsp.apo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/258:51 下午
 **/
@Aspect
@Component
public class BrokerAspect {

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * hcsp.apo.AopController.*(..)))")
    public void pointcut() {
    }

    /**
     * @description 在连接点执行之前执行的通知
     */
    @Before("pointcut()")
    public void doBeforeGame() {
        System.out.println("经纪人正在处理球星赛前事务！");
    }


    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("pointcut()")
    public void doAfterGame(){
        System.out.println("经纪人为球星表现疯狂鼓掌！");
    }
}
