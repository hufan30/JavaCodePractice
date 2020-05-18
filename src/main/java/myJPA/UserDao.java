package myJPA;

public class UserDao extends BaseDao<User> {
    @Override
    public void add(User bean) {
        super.add(bean);
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("hst", 21);
        userDao.add(user);
    }
}
