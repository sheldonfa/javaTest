package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 依赖注入测试
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String classPath = "spring/applicationContext-service.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);
        BookService bookService = context.getBean("bookServiceId", BookService.class);
        bookService.addBook();
    }
}
