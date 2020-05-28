package JDBCDemo.Base2JdbcUtils.DAO;

import JDBCDemo.Base2JdbcUtils.Exception.DaoException;
import JDBCDemo.Base2JdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDao {
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
}
