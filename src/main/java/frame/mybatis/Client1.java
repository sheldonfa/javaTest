package frame.mybatis;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class Client1 {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试通不通
     */
    @Test
    public void testFindById(){
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    /**
     * 返回 List<User>
     */
    @Test
    public void testObj1(){
        List<User> users = userMapper.testObj1();
        System.out.println(users);
    }


    /**
     * 返回List<Map<String,String>>
     *     map的key是对象属性的名，value是属性的值
     */
    @Test
    public void testMap(){
        List<Map<String, Object>> maps = userMapper.testMap1();
        System.out.println(maps);
    }

    @Test
    public void testMap2(){
        Map<String, User> maps = userMapper.testMap2();
        System.out.println(maps);
    }
}
