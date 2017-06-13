package Java基础.c4_class.demo1;

/**
 * 父子类、静态代码块、代码块、构造函数执行顺序
 */
public class Client {
    public static void main(String[] args) {
        Child child = new Child();
        /**
         * 创建两次对象，但是静态代码块只执行一次。说明加载class的时候就执行了
         */
        Child child2 = new Child();
    }
}

/*      father static	// 父的静态代码块
        child static	// 子的静态代码块，它们都是在类加载的时候执行的，创建两个对象也只执行一次。
        father dynamic
        father constructor
        child dynamic
        child constructor
        father dynamic
        father constructor
        child dynamic
        child constructor*/

