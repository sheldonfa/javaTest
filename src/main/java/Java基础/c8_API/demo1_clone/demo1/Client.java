package Java基础.c8_API.demo1_clone.demo1;

import org.junit.Test;

/**
 * 使用clone的方式实现克隆
 *
 * 参考：http://blog.csdn.net/zhangjg_blog/article/details/18369201
 */
public class Client {

    /**
     * 通过clone()可以复制一个对象
     */
    @Test
    public void test1() throws CloneNotSupportedException {
        Person person1 = new Person(1,"john",new Head());
        Person person2 = person1.clone();

        System.out.println(person1==person2);
    }

    /**
     * 但是对于对象内部的引用类型，仍然只是拷贝了地址，叫做浅拷贝
     * person1中的head和person3中的其实是同一个head
     */
    @Test
    public void test2() throws CloneNotSupportedException {
        Person person1 = new Person(1,"john",new Head());
        Person person2 = new Person(1,"john",new Head());
        Person person3 = person1.clone();
        /**
         * 对于引用类型，如这里的Head对象，默认是浅拷贝（即只拷贝了地址）
         */
        System.out.println(person1.getHead()==person2.getHead());
        System.out.println(person1.getHead()==person3.getHead());
    }
}
