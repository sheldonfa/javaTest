package Java基础.c4_class.demo1;

/**
 * @author fangxin
 * @date 2017/5/4.
 */
public class Child extends Father{
    private String g = "father dynamic field";
    {
        System.out.println("child dynamic");
    }
    static{
        System.out.println("child static");
    }
    public Child() {
        System.out.println("child constructor");
    }
}
