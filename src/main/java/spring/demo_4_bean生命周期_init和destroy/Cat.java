package spring.demo_4_bean生命周期_init和destroy;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class Cat {

    public void run(){
        System.out.println("cat run");
    }

    public void myInit(){
        System.out.println("初始化");
    }

    public void myDestroy(){
        System.out.println("销毁");
    }
}
