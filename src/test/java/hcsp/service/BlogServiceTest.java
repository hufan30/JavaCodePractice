package hcsp.service;

import hcsp.dao.BlogDao;
import hcsp.entity.Blog;
import hcsp.entity.BlogListResult;
import hcsp.entity.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BlogServiceTest {
    BlogDao mockDao = Mockito.mock(BlogDao.class);
    BlogService.Logger logger = Mockito.mock(BlogService.Logger.class);
    BlogService blogService = new BlogService(mockDao);
    BlogService blogService2 = new BlogService(mockDao, logger);
    ArgumentCaptor captor = ArgumentCaptor.forClass(String.class);


    @BeforeEach
    void setUp() {
        System.out.println(123);
    }

    @ParameterizedTest
    @CsvSource("2,3,1,10,10")
    void testGetBlogs(int page, int pagesize, int userId, int total, int expectedTotal) {
        List<Blog> blogs = Arrays.asList(Mockito.mock(Blog.class), Mockito.mock(Blog.class), Mockito.mock(Blog.class));
        when(mockDao.getBlogs(page, pagesize, userId)).thenReturn(blogs);
        when(mockDao.count(userId)).thenReturn(total);

        BlogListResult blogListResult = blogService.getBlogs(page, pagesize, userId);
        Assertions.assertEquals(expectedTotal, blogListResult.getTotal());
    }

    @Test
    void testGetBlogsException() {
        String errorMsg = "error for test";
        when(mockDao.getBlogs(anyInt(), anyInt(), anyInt())).thenThrow(new RuntimeException(errorMsg));

        BlogListResult results = blogService2.getBlogs(1, 1, 1);
        Assertions.assertEquals(Result.ResultStatus.FAIL.getStatus(), results.getStatus());
        verify(logger).error(errorMsg);//验证某些东西被调用了，这里验证的是我们mock的logger，但是它在方法中是被调用了的；
//        verify(blogService2).getBlogs(1,1,1);//verify里面验证的是mock的类，不能是实际的类；
        verify(logger).error((String) captor.capture());//这里是captor的用法
        Assertions.assertEquals(errorMsg,captor.getValue());
    }

}