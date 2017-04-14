package com.javabase.exception.my.Demo1_finally中代码在return前执行还是后执行;

/**
 * 1、finally中的代码在return前执行还是后执行的理解。
 */
public class Demo2 {

    /**
     * 返回的结果是2。
     我可以通过下面一个例子程序来帮助我解释这个答案，从下面例子的运行结果中可以发现，
     try 中的 return 语句调用的函数先于 finally 中调用的函数执行，也就是说 return 语句先执行，
     finally 语句后执行，所以，返回的结果是2。 Return 并不是让函数马上返回，而是 return 语
     句执行后，将把返回结果放置进函数栈中，此时函数并不是马上返回，它要执行 finally 语
     句后才真正开始返回
     *
     */
    public static void main(String args[]) {
        Demo2 t = new Demo2();
        int b = t.get();
        System.out.println(b);
    }

    public int get(){
        try{
            System.out.println("try中执行return前");
            return 1 ;
        }finally{
            System.out.println("finally中执行return前");
            return 2 ;
        }
    }
}

