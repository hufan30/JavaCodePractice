package BeanPostProcessor;

import org.springframework.stereotype.Component;

@Component
public interface Calculator {
    public void add(int a, int b);
}
