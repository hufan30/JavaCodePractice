package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.JDBCUtils;
import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoIml implements UserDao {
    @Override
    public int addUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into t_user(name,age, birthday) values (?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
            return ps.executeUpdate();
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    public int delete(User user) throws SQLException {
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
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }

    }

    public int update(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update t_user set name=?, age=?, birthday=? where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
            ps.setInt(4, user.getId());
            return ps.executeUpdate();
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    public User findUser(String name, int age) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, birthday  from t_user where name=? and age=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
            }
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
        return user;
    }

    public User getUser(int userId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, age, birthday from t_user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
            }
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
        return user;
    }

}
