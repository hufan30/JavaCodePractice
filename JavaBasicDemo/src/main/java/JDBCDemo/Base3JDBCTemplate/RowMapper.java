package JDBCDemo.Base3JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    //映射结果集
    Object mapRow(ResultSet rs) throws SQLException;
}
