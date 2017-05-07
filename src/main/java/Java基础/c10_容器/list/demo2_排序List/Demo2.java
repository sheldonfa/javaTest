package Java基础.c10_容器.list.demo2_排序List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 利用Comparator的方式
 */
public class Demo2 {

    public static void main(String[] args) {
        ArrayList<Person2> persons = new ArrayList<>();
        persons.add(new Person2(16,"lisi"));
        persons.add(new Person2(15,"zhangsan"));
        /**
         * 通过Comparator实现外比较
         */
        Collections.sort(persons, new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for(Person2 person: persons){
            System.out.println(person.getName());
        }
    }
}

/**
 * Person2不需要实现任何接口
 */
class Person2 {
    private int age;
    private String name;
    public Person2(int age, String name) {
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
}

