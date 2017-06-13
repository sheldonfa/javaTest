package Java基础.c7_异常.demo1;

/**
 * try {}里有一个 return 语句，那么紧跟在这个 try 后的 finally {}里的 code
 会不会被执行，什么时候被执行，在 return 前还是后?
 * @author fangxin
 * @date 2017/5/9.
 */


public class Main {

    static int test()
    {
        int x = 1;
        try
        {
            return x;
        }
        finally
        {
            ++x;
            System.out.println("finally中的i是："+x);
        }
    }

    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }
    /**
     * 运行结果是1，为什么呢？主函数调用子函数并得到结果的过程，好比主函数准备一个空罐
     子，当子函数要返回结果时，先把结果放在罐子里，然后再将程序逻辑返回到主函数。所谓
     返回，就是子函数说，我不运行了，你主函数继续运行吧，这没什么结果可言，结果是在说
     这话之前放进罐子里的。
     */
}
