package Java基础.c4_class.demo1;

/**
 * @author fangxin
 * @date 2017/5/4.
 */



public class Client2 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("Java基础.c4_class.demo1.Child");
        Class.forName("Java基础.c4_class.demo1.Child");
    }

}
