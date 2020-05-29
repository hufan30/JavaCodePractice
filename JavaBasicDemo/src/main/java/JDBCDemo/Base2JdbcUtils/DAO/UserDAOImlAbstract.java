package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.Exception.DaoException;
import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 从这里开始，使用了模板方法，抽取了AbstractDao之后，明显感觉到有源代码的味道了；
 * 而且从设计和复用的合理性来说，也是大大提升；
 * AbstractDao的作用仅仅是“组装sql语句并执行”，不涉及差异性代码。
 * UserDao/StudentDao/TeacherDao...等有差异的代码仅仅是sql和参数，交给具体实现类编写。
 */
public class UserDAOImlAbstract extends AbstractDao implements UserDao {
    //增
    public int addUser(User user) {
        String sql = "insert into t_user(name, age, birthday) values (?,?,?) ";
        Object[] args = new Object[]{user.getName(), user.getAge(),
                user.getBirthday()};
        //调用父类AbstractDao的方法
        return super.update(sql, args);
    }

    //删
    public int update(User user) {
        String sql = "update t_user set name=?, age=?, birthday=? where id=? ";
        Object[] args = new Object[]{user.getName(), user.getAge(),
                user.getBirthday(), user.getId()};
        return super.update(sql, args);
    }

    //改
    public int delete(User user) {
        String sql = "delete from t_user where id=?";
        Object[] args = new Object[]{user.getId()};
        return super.update(sql, args);
    }

    /**
     * 下面开始是第二阶段的，模板类中有必须子类实现的方法；
     * rowMapper；因为只有子类知道RowSet或者说User，Student的具体映射规则；
     * 没法抽取到父类公用；
     * 但是确实需要一个父类的公用abstract方法；
     */

    //查询
    public User getUser(int id) {
        String sql = "select id, name, age, birthday from t_user where id=?";
        Object[] args = new Object[]{id};
        Object user = super.query(sql, args);
        return (User) user;
    }

    //查询
    public User findUser(String name, int age) {
        String sql = "select id, name, age, birthday from t_user where name=? and age=?";
        Object[] args = new Object[]{name, age};
        Object user = super.query(sql, args);
        return (User) user;
    }

    /**
     * 因为映射规则只能由子类确定，所以这里实现父类当中的抽象方法
     * @param rs
     * @return
     */
    //UserDaoImpl的结果集映射器
    protected Object rowMapper(ResultSet rs) {
        User user = null;
        try {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday"));
        } catch (SQLException e) {
            throw new DaoException("mapping error");
        }
        return user;
    }
}
