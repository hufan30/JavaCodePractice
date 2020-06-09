package XML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {


    // Person依赖Car
    @Autowired
    private Car car;


    // 无参构造
    public Person() {
    }


    // 有参构造
    public Person(Car car) {
        this.car = car;
        System.out.println("通过构造方法注入...");
    }


    // setter方法
    public void setCar(Car car) {
        this.car = car;
        System.out.println("通过setter方法注入...");
    }


    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}
