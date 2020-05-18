package myJPA;

public class MainDemo {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("hst", 22);
        userDao.add(user);
    }
}
