package frame.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class User {
    private Integer id;
    private String  username;
    private Date    birthday;
    private List<Integer> luckyNums;
    private String[]  luckyString;
    private List<Person> friends = new ArrayList();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Integer> getLuckyNums() {
        return luckyNums;
    }

    public void setLuckyNums(List<Integer> luckyNums) {
        this.luckyNums = luckyNums;
    }

    public String[] getLuckyString() {
        return luckyString;
    }

    public void setLuckyString(String[] luckyString) {
        this.luckyString = luckyString;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", luckyNums=" + luckyNums +
                ", luckyString=" + luckyString +
                ", friends=" + friends +
                '}';
    }
}
