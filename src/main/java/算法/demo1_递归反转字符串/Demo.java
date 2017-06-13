package 算法.demo1_递归反转字符串;

/**
 * 用递归实现字符串翻转
 */
public class Demo {

    public static String reverseStr(String str){
        if(str.length()<=1){
            return str;
        }
        return reverseStr(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ab";
        String s3 = "abc";
        String s4 = "abcd";
        String s5 = "abcde";
        String s6 = "abcdef";
        String s7 = "abcdefg";
        System.out.println(reverseStr(s1));
        System.out.println(reverseStr(s2));
        System.out.println(reverseStr(s3));
        System.out.println(reverseStr(s4));
        System.out.println(reverseStr(s5));
        System.out.println(reverseStr(s6));
        System.out.println(reverseStr(s7));
    }
}
