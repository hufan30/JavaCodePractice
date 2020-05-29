package JDBCDemo.Base4DaoFactory;

import JDBCDemo.Base2JdbcUtils.DAO.UserDao;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private UserDao userDao = null;
    private static DaoFactory daoFactory = null;

    private DaoFactory() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //加载properties
        Properties pro = new Properties();
        InputStream resourceAsStream = DaoFactory.class.getClassLoader().getResourceAsStream("jdcb.properties");
        pro.load(resourceAsStream);

        //从properties读取user类型，加载到User中
        //这里读取的是Base3里面的JDBCUtils_DataSource
        String userName = pro.getProperty("userDao");
        Class<?> userClazz = Class.forName(userName);
        userDao = (UserDao) userClazz.newInstance();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
