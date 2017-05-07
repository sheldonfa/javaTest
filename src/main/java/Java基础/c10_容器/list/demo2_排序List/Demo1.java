package Java基础.c10_容器.list.demo2_排序List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 对象实现Comparable接口的方式 实现排序
 */
public class Demo1 {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(16,"lisi"));
        persons.add(new Person(15,"zhangsan"));
        // 排序
        Collections.sort(persons);

        for(Person person: persons){
            System.out.println(person.getName());
        }
    }
}

class Person implements Comparable<Person>{
    private int age;
    private String name;
    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }

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

    /**
     * 重写比较方法
     */
    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }
}
