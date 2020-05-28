package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.Exception.DaoException;
import JDBCDemo.Base2JdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDao {
    // 增删改
    public int update(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);
            // 遍历设置模板参数
            for (int i = 0; i < args.length; i++){
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    //查询
    public Object query(String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);
            // 遍历设置模板参数
            for (int i = 0; i < args.length; i++)
                ps.setObject(i + 1, args[i]);
            rs = ps.executeQuery();
            Object obj = null;
            // 结果集映射，子类必须实现抽象方法rowMapper
            if (rs.next()) {
                obj = rowMapper(rs);
            }
            return obj;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }

    // 定义成抽象方法，让子类去实现
    /**
     * 这里也有源码的味道；
     * 某些抽象方法，父类无法制定一个通用代码满足所有子类的结果集映射，
     * 因为只有子类自己知道映射规则。所以，我们只能把结果集映射的权利交还给子类去实现。
     */
    abstract protected Object rowMapper(ResultSet rs);
}
