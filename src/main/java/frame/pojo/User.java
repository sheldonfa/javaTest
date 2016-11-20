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
    private List<String> friends = new ArrayList<String>();
    private List<Integer> luckyNums = new ArrayList<Integer>();

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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<Integer> getLuckyNums() {
        return luckyNums;
    }

    public void setLuckyNums(List<Integer> luckyNums) {
        this.luckyNums = luckyNums;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", friends=" + friends +
                ", luckyNums=" + luckyNums +
                '}';
    }
}
