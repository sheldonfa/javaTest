package Java基础.c4_class.demo1;


/**
 * 直接加载类，也会触发静态代码块的执行
 */
public class Client2 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("Java基础.c4_class.demo1.Child");
        Class.forName("Java基础.c4_class.demo1.Child");
    }

}
