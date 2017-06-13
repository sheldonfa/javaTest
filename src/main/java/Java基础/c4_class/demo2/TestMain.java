package Java基础.c4_class.demo2;

/**
 * super.getClass有意义吗？
 * @author fangxin
 * @date 2017/5/9.
 */

class Father{

}

public class TestMain extends Father{

    public String test(){

        /**
         * getClass方法在Object中，并且是final的，所以不管是直接调用，还是super.getClass都是一样的
         */
        return super.getClass().getName();
    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        System.out.println(testMain.test());
    }
}
