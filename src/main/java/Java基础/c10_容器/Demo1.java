package Java基础.c10_容器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * List怎么排序？TreeSet或者Collections.sort
 */

class Student{
    private String name;
    private Integer age;
}

class Student2 implements Comparable<Student2>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student2 o) {
        return this.age-o.age;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        List<Student2> list2 = new ArrayList<>();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
        Collections.sort(list2);
    }
}
