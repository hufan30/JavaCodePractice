package Dao;

import pojo.User;

import java.util.List;

/**
 * @author hufan
 * @date 2020/6/2 10:57 下午
 * @annotation
 */
public interface UserDao {
    List<User> getUserList();
}
