package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int addUser(User user) throws SQLException;
    int update(User user) throws SQLException;
    int delete(User user) throws SQLException;
    User getUser(int Id) throws SQLException;
    User findUser(String name, int age) throws SQLException;

    //新增查询方法：根据年龄查询
    List<User> selectUsers(Integer age);
}
