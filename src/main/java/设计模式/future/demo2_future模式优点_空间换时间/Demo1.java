package 设计模式.future.demo2_future模式优点_空间换时间;

/**
 *
 * 执行一个方法，这个方法由两部分组成，分别耗时1秒
 */

class A{

    public String run() {
        try {
            Thread.sleep(2000);
            System.out.println("A run over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "a result";
    }
}

class B{
    public String run() {
        try {
            Thread.sleep(2000);
            System.out.println("B run over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "b result";
    }
}

public class Demo1 {

    public String run(){
        A a = new A();
        String resultA = a.run();
        B b = new B();
        String resultB = b.run();
        return resultA + resultB;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        String result = demo1.run();
        System.out.println(result);
    }

}
