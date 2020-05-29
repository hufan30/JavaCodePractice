package JDBCDemo.Base2JdbcUtils.POJO;

import java.sql.Date;

public class User {
    private int  id;
    private String name;
    private Integer age;
    private Date birthday;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
