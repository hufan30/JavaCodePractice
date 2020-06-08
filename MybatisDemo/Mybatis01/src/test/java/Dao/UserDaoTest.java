package Dao;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author hufan
 * @date 2020/6/2 11:11 下午
 * @annotation
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserListTest() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.info(sqlSession);
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
    public void getUserLikeTest() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserLike("李");

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

    @Test
    public void updateUserTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserDao mapper = sqlSession.getMapper(UserDao.class);

            int res = mapper.updateUser(new User(4, "hufanUpdate", "456Update"));

            if(res>0) System.out.println("更新成功！");

            sqlSession.commit();
        }
    }

    /**
     * 这里开始使用map来注入参数
     */
    @Test
    public void addUser2Test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            HashMap<String, Object> userMap = new HashMap<>();
            userMap.put("userid",5);
            userMap.put("passWord","23333");

            int res = userDao.addUser2(userMap);

            if(res>0){
                System.out.println("插入成功！");
            }
            //在没有这句之前，虽然也打印了插入成功，但是数据库里并没有进入数据；
            sqlSession.commit();
        }
    }
}

