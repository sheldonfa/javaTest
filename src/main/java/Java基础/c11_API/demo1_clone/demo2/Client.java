package Java基础.c11_API.demo1_clone.demo2;


import org.junit.Test;

/**
 * clone深拷贝
 *
 * 参考：http://blog.csdn.net/zhangjg_blog/article/details/18369201
 */
public class Client {

    /**
     * 深拷贝：对象属性也拷贝，属性也重写clone方法
     */
    @Test
    public void test3() throws CloneNotSupportedException {
        Person person1 = new Person(1,"lisi",new Head());
        Person person2 = person1.clone();

        System.out.println(person1.getHead()==person2.getHead());
    }

    /**
     * 虽然person是深拷贝了，但是不彻底
     * 因为 head中的face仍然是指向同一个对象的。
     */
    @Test
    public void test4() throws CloneNotSupportedException {
        Person person1 = new Person(1,"lisi",new Head());
        Person person2 = person1.clone();

        System.out.println(person1.getHead().getFace()==person2.getHead().getFace());
    }

    /**
     * 写在最后：
     * 由此看来，如果你的对象够复杂 Person--》Head--》Face--》Mouth--》Touth
     * 想要实现彻底的深拷贝是不太可能的。
     */
}
