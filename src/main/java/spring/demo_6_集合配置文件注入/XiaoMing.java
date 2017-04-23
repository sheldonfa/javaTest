package spring.demo_6_集合配置文件注入;

import java.util.List;
import java.util.Map;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class XiaoMing{

    private Integer age;

    private List<String> hobbies;

    private Map<String,String> friends;

    private Map<String,String> girls;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, String> friends) {
        this.friends = friends;
    }

    public Map<String, String> getGirls() {
        return girls;
    }

    public void setGirls(Map<String, String> girls) {
        this.girls = girls;
    }
}
