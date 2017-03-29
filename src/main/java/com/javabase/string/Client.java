package com.javabase.string;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/17 0017.
 */
public class Client {

    /**
     * 不可变性
     */
    @Test
    public void test1(){
        String a = "hello";
        String b = a.toUpperCase();
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 编译器拼接优化
     */
    @Test
    public void test2(){
        String aa = "aa";
        String result = "bb"+"aa"+"cc";
    }

    /**
     * 循环拼接，编译器低效
     */
    public void test3(String[] fields){
        String result = "";
        for(int i=0;i<100;i++){
            result += fields[i];
        }
        System.out.println(result);
    }

    /**
     * 手动使用StringBuilder优化
     */
    public void test4(String[] fields){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<100;i++){
            result.append(fields[i]);
        }
        System.out.println(result);
    }

    /**
     * 常用String工具方法
     * length
     * charAt 目标索引上的字符
     */
    @Test
    public void test5(){
        String str = "hello jack";
        // 求长度
        int length = str.length();
        System.out.println(length);
        // 取得索引上的char
        char c = str.charAt(5);
        System.out.println(c);
    }

    /**
     * getChars() 将自定义字符串部分，转向一个字符数组容器
     * getBytes() 获取字节数组
     * toCharArray() 获取字符数组
     *
     */
    @Test
    public void test6() throws UnsupportedEncodingException {
        String str = "hello jack";
        char[] chars = new char[10];
        str.getChars(1,3,chars,2);
        System.out.println(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        char[] chars2 = str.toCharArray();
        System.out.println(chars2);
        byte[] bytes1 = str.getBytes("iso8859-1");
        System.out.println(Arrays.toString(bytes1));
    }

    /**
     * equals
     * equalsIgnoreCase
     * contentEquals 只要是CharSequence接口的子类就可以比较，不会因为类型不同而返回false。CharSequence 的子类有StringBuffer，StringBuilder，String等等，这里挑一个最不熟悉的CharArray试试
     */
    @Test
    public void test7(){
        String str = "hello world";
        char[] ch = new char[]{'h','e','l','l','o',' ','w','o','r','l','d'};
        CharArray charArray = new CharArray(ch, 0, ch.length, false);
        boolean res1 = str.equals(charArray);
        boolean res2 = str.contentEquals(charArray);
        System.out.println(res1);
        System.out.println(res2);
    }

    /**
     * compareTo 按字典顺序，大小写不等价
     *
     */
    @Test
    public void test8(){
        String str1 = "aabbc";
        String str2 = "aabbC";
        int i = str1.compareTo(str2);
        // "aabbc"比"aabbC"大32
        System.out.println(i);
        System.out.println(Arrays.toString("c".getBytes()));
        System.out.println(Arrays.toString("C".getBytes()));
    }

    /**
     * contains
     */
    @Test
    public void test9(){
        String str1 = "hello world";
        String ch = "lo";
        boolean contains = str1.contains(ch);
        System.out.println(contains);
    }

    /**
     * 字符串区域比较 参数1：一号字符串起始位置，参数二：二号字符串，参数三：三号字符串起始位置，参数四：比较深度
     */
    @Test
    public void test11(){
        String str1 = "hello";
        String str2 = "allo";
        boolean b = str1.regionMatches(2,str2,1,3);
        System.out.println(b);
    }

    /**
     * startWith
     * endWith
     */
    @Test
    public void test12(){
        String str1 = "hello";
        boolean h = str1.startsWith("h");
        boolean e = str1.startsWith("e");
        boolean o = str1.endsWith("o");
        System.out.println(h);
        System.out.println(e);
        System.out.println(o);
    }

    /**
     * indexOf
     * lastIndexOf
     */
    @Test
    public void test13(){
        String str = "hello";
        int l = str.indexOf("l");
        int l1 = str.lastIndexOf("l");
        System.out.println(l);
        System.out.println(l1);
    }

    /**
     * substring
     */
    @Test
    public void test14(){
        String str = "hello";
        String substring = str.substring(1, 2);
        System.out.println(substring);
    }

    /**
     * concat
     */
    @Test
    public void test15(){
        String s1 = "hello";
        String s2 = " world";
        String concat = s1.concat(s2);
        System.out.println(concat);
    }

    /**
     * replace
     * toLowerCase
     * toUpperCase
     */
    @Test
    public void test16(){
        String s1 = "hello o";
        String replace = s1.replace("o", "world");
        System.out.println(replace);
    }

    /**
     * trim
     */
    @Test
    public void test17(){
        String s1 = " aa ";
        System.out.println(s1);
        System.out.println(s1.trim());
    }

    /**
     * valueOf
     */
    @Test
    public void test18(){
        char[] s = new char[]{'h','e','l','l','o'};
        String s2 = String.valueOf(s);
        System.out.println(s2);
    }

    /**
     * intern
     */
    @Test
    public void test19(){
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1==s2);
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3==s3);
    }

    /**
     * jdk1.7中，首次出现的常量，会添加到方法区中的运行时常量池中
     * "java"在执行s2的时候已经出现过，不属于第一次
     */
    @Test
    public void test19a(){
        String s1 = new StringBuilder("计算器").append("软件").toString();
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s1.intern()==s1);
        System.out.println(s2.intern()==s2);
    }

    @Test
    public void test19b(){
        String s1 = new StringBuilder("计算器").append("软件").toString();
        String s2 = new StringBuilder("计算器").append("软件").toString();
        System.out.println(s1.intern()==s1);
        System.out.println(s2.intern()==s2);
    }

    /**
     * 正则表达式
     */
    @Test
    public void test20(){
        System.out.println("\\");
        // java中前两个反斜线转义一个正则反斜线，后两个反斜线转义一个正则反斜线，然后，前面的反斜线转义后面的反斜线，输出一个反斜线
        System.out.println("\\".matches("\\\\"));
    }

    /**
     * 例子：可能以一个加号和减号开头的数字
     * 括号可以将表达式分组
     * |是或者的意思
     * (-|+)?的意思就是可能有-号或者+号，但是+是特殊字符，需要转义，所以（-|\\+）?
     * \\d+表示一位或者多为数字
     */
    @Test
    public void test21(){
        System.out.println("15".matches("(-|\\+)?\\d+"));
        System.out.println("-15".matches("(-|\\+)?\\d+"));
        System.out.println("+15".matches("(-|\\+)?\\d+"));
    }

    /**
     * split
     * s1表示以空格分隔
     * s2表示以非单词字符分隔。+加号表示一个或多个
     * s3表示以d和后面的非单词字符分隔
     */
    @Test
    public void test22(){
        String str = "hello world,,im kong";
        String[] s1 = str.split(" ");
        String[] s2 = str.split("\\W+");
        String[] s3 = str.split("d\\W+");
        for(String s:s1){
            System.out.print(s+" ");
        }
        System.out.println();
        for(String s:s2){
            System.out.print(s+" ");
        }
        System.out.println();
        for(String s:s3){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    /**
     * replace
     *
     */
    @Test
    public void test23(){
        String str = "hello world,im wang";
        // 匹配第一个world替换成java
        String s1 = str.replaceFirst("world", "java");
        // 匹配第一个w开头的单词，替换成java
        String s2 = str.replaceFirst("w\\w+", "java");
        // 匹配所有w开头的单词，替换成java
        String s3 = str.replaceAll("w\\w+", "java");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    /**
     * 运用字符类匹配
     */
    @Test
    public void test25(){
        for(String pattern: new String[]{"hello","[h]ello","hell[aeiou]","he[lL].","he[lL]*","he[lL].*",}){
            System.out.println("hello".matches(pattern));
        }
    }

    /**
     * 贪婪型（最大匹配）：匹配字符串尽可能长，如<.+>的结果“<tr>aava </tr>”
     * 勉强型（最小匹配）：匹配字符串尽可能短，如<.+?>的结果两个 “<tr>” 和 “</tr>”
     * 占有型（完全匹配）：一种不回溯的匹配模式，更严格，
     *      如<.++>，由于字符串“a<tr>aava </tr>abb”中，从第一个"<"开始，每一个字符都满足“.+”的条件，所以会一直匹配下去，到最后，当到最后一个"b"的时候发现匹配完了，根本就没有字符再去匹配“>”了，所以没有可匹配的结果
     *      如<[a-z/]++>，与上面不同的是，当遇到字符串中第一个">"时，[a-z/]+无法匹配上，那么就接着匹配">"，结果正中靶心。而这种情况一共两次，所以结果集是“<tr>”和“</tr>”
     *
     */
    @Test
    public void test26(){
        String[] args = new String[]{"<.+>","<.+?>","<.++>","<[a-z/]++>"};
        for(String arg: args){
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher("a<tr>aava </tr>abb");
            while(matcher.find()){
                System.out.println("匹配"+arg);
                System.out.println(matcher.group());
            }
        }
    }

    /**
     * ^的使用
     */
    @Test
    public void test27(){
        String[] args = new String[]{"[^h].*","^h.*"};
        for(String arg: args){
            System.out.println("hello".matches(arg));
        }
    }

    /**
     * Scanner
     */
    @Test
    public void test28(){
        Scanner scanner = new Scanner("aa\n15");
        System.out.println("你的名字");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("你的年龄");
        String age = scanner.nextLine();
        System.out.println(age);
    }

    /**
     * Scanner的定界符
     */
    @Test
    public void test29(){
        Scanner scanner = new Scanner("aa, 15");
        scanner.useDelimiter("\\s*,\\s*");
        System.out.println("你的名字");
        String name = scanner.next();
        System.out.println(name);
        System.out.println("你的年龄");
        String age = scanner.next();
        System.out.println(age);
    }


    @Test
    public void test30(){
        String s = "aaabdcef";
        StringBuffer sb = new StringBuffer(s);
        StringBuffer reverse = sb.reverse();
        System.out.println(reverse.toString());
    }
}
