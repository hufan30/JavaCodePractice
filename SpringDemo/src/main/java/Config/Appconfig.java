package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //表示这个Java类充当XML配置文件
@ComponentScan(basePackages = "XML") //相当于XML中的<context:component-scan>标签
public class Appconfig {


}
