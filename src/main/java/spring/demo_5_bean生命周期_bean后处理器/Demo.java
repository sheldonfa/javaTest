package spring.demo_5_bean生命周期_bean后处理器;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String filePath = "G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\spring\\demo_5_bean生命周期_bean后处理器\\bean.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(filePath);
        LiyuService liyu = context.getBean("liyu", LiyuService.class);
        liyu.run();
    }
}
