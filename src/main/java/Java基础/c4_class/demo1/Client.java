package Java基础.c4_class.demo1;

public class Client {
    public static void main(String[] args) {
        Child child = new Child();
        /**
         * 创建两次对象，但是静态代码块只执行一次。说明加载class的时候就执行了
         */
        Child child2 = new Child();
    }
}


