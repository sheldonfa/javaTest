package Java基础.c4_class.demo3;

import org.junit.Assert;
import org.junit.Test;

/**
 * 子类可以继承父类的私有属性吗
 * Created by lingban on 2017/6/13.
 */

class Parent {

    private String  name;

    private int     age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Sun extends Parent {

}

public class Client {

    /**
     * 1、子类拥有所有的父类属性
     */
    @Test
    public void test1(){
        Sun sun = new Sun();
        sun.setName("zhangsan");
        System.out.println(sun.getName());
    }

    /**
     * 2、但是子类不能访问父类的属性
     */
    @Test
    public void test2(){
    }
    /**
     * 3、属性没有多态的特性
     */
}
