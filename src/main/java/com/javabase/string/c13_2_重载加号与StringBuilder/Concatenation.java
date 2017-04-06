package com.javabase.string.c13_2_重载加号与StringBuilder;

/**
 * String拼接自动优化
 *
 * 通过反编译查看
 */
public class Concatenation {

    public static void main(String[] args) {
        String a = "aa";
        String result = "bb"+a+"cc";
        System.out.println(result);
    }
}
