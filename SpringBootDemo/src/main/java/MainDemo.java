import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "AopDemo" })
public class MainDemo {
    // 启动切面
    public static void main(String[] args) {
        SpringApplication.run(MainDemo.class, args);
    }
}
