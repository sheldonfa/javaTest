package frame.springmvc;

import frame.pojo.Person;
import frame.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/20.
 * 关于spring mvc 复杂参数的接收方式
 * 对于部分类型是不兼容的，例如当map的key不是string类型
 */
@RequestMapping("/mvc/client1")
@Controller
public class Client1 {

    /**
     * 简单类型list
     * explain:包含string int date 等属性
     */
    @RequestMapping("/test1")
    @ResponseBody
    public void test1(@RequestParam("idList[]") List<Integer> idList){
        for(Integer i: idList){
            System.out.println(i);
        }
    }

    /**
     * 简单对象
     *
     */
    @RequestMapping("/test2")
    @ResponseBody
    public void test2(User user){
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
    }

    /**
     * 复杂对象
     * explain:包含简单list属性、对象list属性
     */
    @RequestMapping("/test3")
    @ResponseBody
    public void test3(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        for(Integer i:user.getLuckyNums()){
            System.out.println(i);
        }
        for(Person p:user.getFriends()){
            System.out.println(p.getName());
        }
    }

    /**
     * ★★★复杂对象+简单参数
     * explain:包含对象list属性
     */
    @RequestMapping("/test4/{id}")
    @ResponseBody
    public void test4(@PathVariable Integer id,@RequestBody User user){
        System.out.println(id);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        for(Integer i:user.getLuckyNums()){
            System.out.println(i);
        }
        for(Person p:user.getFriends()){
            System.out.println(p.getName());
        }
    }

    /**
     * 复杂List
     */
    @RequestMapping("/test5")
    @ResponseBody
    public void test5(@RequestBody List<User> users){
        for(User user:users){
            System.out.println(user.getUsername());
        }
    }

    /**
     * List<Map<String,Object>>
     * 注意：map的key一定要是string类型才可以
     */
    @RequestMapping("/test6")
    @ResponseBody
    public void test6(@RequestBody List<Map<String,String>> users){
        for(Map<String,String> map:users){
            for(Map.Entry<String,String> entry:map.entrySet()){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        }
    }

    /**
     * Map<String,Object>
     * 注意：map的key一定要是string类型才可以
     */
    @RequestMapping("/test7")
    @ResponseBody
    public void test7(@RequestBody Map<String,String> user){
        System.out.println(user);
    }

    @RequestMapping("/index")
    public String client1(){
        return "client1";
    }
}
