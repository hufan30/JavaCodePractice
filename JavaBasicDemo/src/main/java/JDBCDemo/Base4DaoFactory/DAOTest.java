package JDBCDemo.Base4DaoFactory;

import JDBCDemo.Base2JdbcUtils.DAO.UserDao;
import JDBCDemo.Base2JdbcUtils.POJO.User;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        List<User> users = userDao.selectUsers(1);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
