package hcsp;

import hcsp.dao.BlogDao;
import hcsp.entity.BlogListResult;
import hcsp.entity.Result;
import hcsp.service.BlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/161:01 下午
 **/
@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class SpringbootDemotest {
    @Mock
    BlogDao mockDao;
    @Mock
    BlogService.Logger logger;
    @Captor
    ArgumentCaptor captor;
    @InjectMocks
    BlogService blogService;
    @InjectMocks
    BlogService blogService2;

    //这里要注意使用的是junit4的@Test还是Junit5的
    //如果是4的开头用//@RunWith(MockitoJUnitRunner.class)
    //如果是5的开头用@ExtendWith(MockitoExtension.class)
    @Test
    public void testGetBlogsException() {
        String errorMsg = "error for test";
        when(mockDao.getBlogs(anyInt(), anyInt(), anyInt())).thenThrow(new RuntimeException(errorMsg));

        BlogListResult results = blogService2.getBlogs(1, 1, 1);
        Assertions.assertEquals(Result.ResultStatus.FAIL.getStatus(), results.getStatus());
        verify(logger).error(errorMsg);//验证某些东西被调用了，这里验证的是我们mock的logger，但是它在方法中是被调用了的；
//        verify(blogService2).getBlogs(1,1,1);//verify里面验证的是mock的类，不能是实际的类；
        verify(logger).error((String) captor.capture());//这里是captor的用法
        Assertions.assertEquals(errorMsg, captor.getValue());
    }
}
