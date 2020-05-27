package JDBCDemo.Base1;

import org.junit.Test;
import java.sql.*;

/**
 * @description: 最原始的JDBC连接代码，其中的异常处理很模糊
 * @author: HuFan
 * @time: 2020/2/1810:14 下午
 **/
public class Base1 {
    @Test
    public void testJdbc() throws SQLException, ClassNotFoundException {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.建立连接
        String url = "jdbc:mysql://192.168.136.128:3306/test";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.创建sql模板
        String sql = "select * from t_user where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        // 4.设置模板参数
        preparedStatement.setInt(1, 5);

        // 4.执行语句
        ResultSet rs = preparedStatement.executeQuery();

        // 5.处理结果
        while (rs.next()) {
            System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t"
                    + rs.getObject(3) + "\t" + rs.getObject(4));
        }

        // 6.释放资源
        rs.close();
        preparedStatement.close();
        conn.close();
    }
}
