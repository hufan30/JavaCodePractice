package JDBCDemo.Base2JdbcUtils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Base2 {
    //请注意，这里抛了异常
    @Test
    public void testJdbc() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName("JDBCDemo.Base2JdbcUtils.JDBCUtils");
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();

            // 2.创建sql模板
            String sql = "select * from t_user where id = ?";
            ps = conn.prepareStatement(sql);

            // 3.设置模板参数
            ps.setInt(1, 5);

            // 4.执行语句
            rs = ps.executeQuery();

            // 5.处理结果
            while (rs.next()) {
                System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t"
                        + rs.getObject(3) + "\t" + rs.getObject(4));
            }
        } finally {
            // 6.释放资源
            JDBCUtils.free(rs, ps, conn);
        }
    }
}
