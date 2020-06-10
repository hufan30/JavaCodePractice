package Dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author hufan
 * @date 2020/6/2 10:57 下午
 * @annotation
 */
public interface UserMapper {

    //分页
    List<User> getUserByLimit(Map<String, Integer> map);

    List<User> getUserList();

    User getUserbyId(int id);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    List<User> getUserLike(String like);
}
