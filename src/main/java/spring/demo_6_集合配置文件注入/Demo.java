package spring.demo_6_集合配置文件注入;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String filePath = "G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\spring\\demo_6_集合配置文件注入\\bean.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(filePath);
        XiaoMing xiaoMing = context.getBean("xiaoMing", XiaoMing.class);
        System.out.println(xiaoMing);
    }
}
