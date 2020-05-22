package ProxyDemo.SpringBootJDKDemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceIml implements UserService {
    @Override
    public void server() {
        System.out.println("this is UserServiceIml");
    }
}
