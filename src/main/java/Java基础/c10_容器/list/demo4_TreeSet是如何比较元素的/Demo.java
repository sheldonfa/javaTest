package Java基础.c10_容器.list.demo4_TreeSet是如何比较元素的;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class Demo {

    /**
     * 直接创建一个TreeSet，插入数据，然后遍历，直接就挂掉了
     *
     * 因为TreeSet也不知道怎么比较
     */
    @Test
    public void test1(){
        TreeSet<Person> set = new TreeSet<>();
        Person wangwu = new Person(17, "wangwu");
        Person lisi = new Person(16, "lisi");
        Person zhangsan = new Person(15, "zhangsan");
        set.add(wangwu);
        set.add(lisi);
        set.add(zhangsan);

        for(Person p : set){
            System.out.println(p.getName());
        }
    }

    /**
     * 第一种排序方式：对象实现Comparable接口
     */
    @Test
    public void test2(){
        TreeSet<Person2> set = new TreeSet<>();
        Person2 wangwu = new Person2(17, "wangwu");
        Person2 lisi = new Person2(16, "lisi");
        Person2 zhangsan = new Person2(15, "zhangsan");
        set.add(wangwu);
        set.add(zhangsan);
        set.add(lisi);

        for(Person2 p : set){
            System.out.println(p.getName());
        }
    }

    /**
     * 第二种排序方式：自己实现Comparator，通过构造器告诉TreeSet
     */
    @Test
    public void test3(){
        TreeSet<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        Person wangwu = new Person(17, "wangwu");
        Person lisi = new Person(16, "lisi");
        Person zhangsan = new Person(15, "zhangsan");
        set.add(wangwu);
        set.add(zhangsan);
        set.add(lisi);

        for(Person p : set){
            System.out.println(p.getName());
        }
    }
}
