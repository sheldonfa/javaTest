package com.javabase.exception.my.Demo1_finally中代码在return前执行还是后执行;

/**
 * 1、finally中的代码在return前执行还是后执行的理解。
 */
public class Demo1 {
    /**
     * 2、通常说是在return前，那么结果应该是2才对，为什么是1呢？
     */
    public static void main(String[] args) {
        System.out.println(new Demo1().test());
    }

    static int test() {
        int x = 1;
        try {
            /**
             * 3、运行结果是1，为什么呢？主函数调用子函数并得到结果的过程，好比主函数准备一个空罐
             子，当子函数要返回结果时，先把结果放在罐子里，然后再将程序逻辑返回到主函数。所谓
             返回，就是子函数说，我不运行了，你主函数继续运行吧，这没什么结果可言，结果是在说
             这话之前放进罐子里的。
             */
            return x;
        } finally {
            ++x;
        }
    }
}

