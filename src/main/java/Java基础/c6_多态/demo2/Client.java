package Java基础.c6_多态.demo2;


/**
 * 抽象方法是否可以重载具体方法
 */
abstract class Cat{
    static String a = "aa";
    static String b = a+"b";

    String str = "aa";
    String str2 = str+"bb";

    public void run(){

    }

    public abstract void run(String a);
}

public class Client {
    /**
     * 抽象方法 可以与 具体方法重载
     */
    public static void main(String[] args) {
        // 静态变量也可以调用
        String b = Cat.b;
        System.out.println(b);
    }

}
