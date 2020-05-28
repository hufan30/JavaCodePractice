package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.Exception.DaoException;
import JDBCDemo.Base2JdbcUtils.JDBCUtils;
import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.sql.*;

public class UseDaoImlException implements UserDao {

    public int addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into t_user(name,age, birthday) values (?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, new Date(user.getBirthday().getTime()));
            return ps.executeUpdate();
        } catch (SQLException e) {
            //转为DaoException（运行时异常）抛出，Service层可以不处理
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    public int delete(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from t_user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            System.out.println(sql);
            return ps.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }

    }

    public int update(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update t_user set name=?, age=?, birthday=? where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, new Date(user.getBirthday().getTime()));
            ps.setInt(4, user.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    public User findUser(String name, int age) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = new User();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, birthday  from t_user where name=? and age=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
        return user;
    }

    public User getUser(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = new User();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, age, birthday from t_user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
        return user;
    }
}
