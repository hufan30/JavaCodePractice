package Dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

/**
 * @author hufan
 * @date 2020/6/2 11:11 下午
 * @annotation
 */
public class UserDaoTest {
    @Test
    public void getUserListTest() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserbyIdTest() {
        //第一步：获得SqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            //方式一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
//            List<User> userList = userDao.getUserList();
            User userbyId = userDao.getUserbyId(2);
            System.out.println(userbyId);
        }

    }

    @Test
    public void addUserTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            int res = userDao.addUser(new User(4,"hufan","123"));

            if(res>0){
                System.out.println("插入成功！");
            }
            //在没有这句之前，虽然也打印了插入成功，但是数据库里并没有进入数据；
            sqlSession.commit();
        }
    }
}

