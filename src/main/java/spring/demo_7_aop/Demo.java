package spring.demo_7_aop;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String filePath = "G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\spring\\demo_7_aop\\bean.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(filePath);
        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser();
    }
}
