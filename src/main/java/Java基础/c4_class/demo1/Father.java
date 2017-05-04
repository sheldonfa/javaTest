package Java基础.c4_class.demo1;

/**
 * @author fangxin
 * @date 2017/5/4.
 */
public class Father {
    {
        System.out.println("father dynamic");
    }
    static{
        System.out.println("father static");
    }
    public Father() {
        System.out.println("father constructor");
    }
}
