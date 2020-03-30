package SpringMVCBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/2710:42 上午
 **/
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class Application2 {
    public static void main(String[] args) {
        SpringApplication.run(Application2.class, args);
    }
}
