package Java基础.c10_容器.list.demo4_TreeSet是如何比较元素的;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class Person2 implements Comparable<Person2>{
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

    @Override
    public int compareTo(Person2 o) {
        return this.getAge()-o.getAge();
    }
}
