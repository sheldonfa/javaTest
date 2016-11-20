package frame.springmvc;

import frame.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/20.
 */
@RequestMapping("springUser")
@Controller
public class Client {

    @RequestMapping("/userIndex")
    public String userIndex(){
        return "user";
    }

    /**
     * ajax如何传递对象的list属性，如：user.friends
     * 答：通过对象({0:"zhangsan",1:"lisi"})传递，key为数组下表，value为值
     * @param user
     * @param request
     */
    @RequestMapping("/getUser")
    public void getUser(User user, HttpServletRequest request){
        Integer lucky = user.getLuckyNums().get(0);
        System.out.println("答案"+lucky);
    }

    /**
     * 上传
     */
    // TODO: 2016/11/20   
    @RequestMapping("/unload")
    public void upload(){
        System.out.println("上传");
    }
}
