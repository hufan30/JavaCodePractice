package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.POJO.User;

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
    //待实现
    public User getUser(int Id) {
        return null;
    }
    //待实现
    public User findUser(String name, int age) {
        return null;
    }
}
