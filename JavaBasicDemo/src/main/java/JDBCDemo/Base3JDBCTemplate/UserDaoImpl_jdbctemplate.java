package JDBCDemo.Base3JDBCTemplate;

import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl_jdbctemplate {
    MyJDBCTemplate jdbcTemplate = new MyJDBCTemplate();

    //增
    public int addUser(User user) {
        String sql = "insert into t_user(name, age, birthday) values (?,?,?) ";
        Object[] args = new Object[]{user.getName(), user.getAge(),
                user.getBirthday()};
        //调用jdbcTemplate的update方法
        return jdbcTemplate.update(sql, args);
    }

    //删
    public int update(User user) {
        String sql = "update t_user set name=?, age=?, birthday=? where id=? ";
        Object[] args = new Object[]{user.getName(), user.getAge(),
                user.getBirthday(), user.getId()};
        //调用jdbcTemplate的update方法
        return jdbcTemplate.update(sql, args);
    }

    //改
    public int delete(User user) {
        String sql = "delete from t_user where id=?";
        Object[] args = new Object[]{user.getId()};
        //调用jdbcTemplate的update方法
        return jdbcTemplate.update(sql, args);
    }

    //查询单个
    public User getUser(int id) {
        String sql = "select id, name, age, birthday from t_user where id=?";
        Object[] args = new Object[]{id};
        //调用jdbcTemplate的query方法，传入sql，args，RowMapper匿名对象
        List list = jdbcTemplate.query(sql, args, new RowMapper() {
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
        });
        return (User)list.get(0);
    }

    public User findUser(String name, int age) {
        String sql = "select id, name, age, birthday from t_user where name=? and age=?";
        Object[] args = new Object[]{name, age};
        //调用jdbcTemplate的query方法，传入sql，args，RowMapper匿名对象
        List list = jdbcTemplate.query(sql, args, new RowMapper() {
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
        });
        return (User)list.get(0);
    }

    //查询多个
    public List selectUsers(int age) {
        String sql = "select id, name, age, birthday from t_user where age=?";
        Object[] args = new Object[]{age};
        //调用jdbcTemplate的query方法，传入sql，args，RowMapper匿名对象
        List list = jdbcTemplate.query(sql, args, new RowMapper() {
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
        });
        return list;
    }
}
