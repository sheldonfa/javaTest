package spring.demo_5_bean生命周期_bean后处理器;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class Liyu implements LiyuService{


    public void run(){
        System.out.println("liyu run");
    }

    public void myInit(){
        System.out.println("初始化");
    }

    public void myDestroy(){
        System.out.println("销毁");
    }
}
