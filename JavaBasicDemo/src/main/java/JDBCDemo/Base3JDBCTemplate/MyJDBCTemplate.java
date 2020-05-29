package JDBCDemo.Base3JDBCTemplate;

import JDBCDemo.Base2JdbcUtils.Exception.DaoException;
import JDBCDemo.Base2JdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyJDBCTemplate {
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

    //查询，RowMapper是接口类型，需要传入接口的实现类对象
    public List<Object> query(String sql, Object[] args, RowMapper rowMapper) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            conn = JDBCUtils.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);
            // 遍历设置模板参数
            for (int i = 0; i < args.length; i++)
                ps.setObject(i + 1, args[i]);
            rs = ps.executeQuery();
            Object obj = null;
            // 映射规则由子类传入
            while (rs.next()) {
                Object o = rowMapper.mapRow(rs);
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(rs, ps, conn);
        }
    }
}
