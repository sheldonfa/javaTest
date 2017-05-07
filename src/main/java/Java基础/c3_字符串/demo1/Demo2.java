package Java基础.c3_字符串.demo1;

/**
 * jdk1.7以后的特点
 * @author fangxin
 * @date 2017/4/20.
 */
public class Demo2 {

    public static void main(String[] args) {

        // jdk1.7中，首次出现的常量，会添加到方法区中的运行时常量池中,并指向常量池
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("go").append("od").toString();
        System.out.println(s2.intern() == s2);
    }
}
