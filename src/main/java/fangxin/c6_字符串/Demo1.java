package fangxin.c6_字符串;

/**
 * @author fangxin
 * @date 2017/4/17.
 */
public class Demo1 {
    public static void main(String[] args) {
        String s1 = "Programming";
//        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
        // false
        // true
        // true
        // true
        // false
    }
}
