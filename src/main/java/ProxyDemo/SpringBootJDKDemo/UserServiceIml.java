package ProxyDemo.SpringBootJDKDemo;

import ProxyDemo.MyTransactionDemo.Annotation.MyTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@MyTransactional
public class UserServiceIml implements UserService {
    @Override
    public void server() {
        System.out.println("this is UserServiceIml");
    }
}
