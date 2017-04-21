package Java基础.c5_object;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxin
 * @date 2017/4/21.
 */

class Student {
    private int age;

    public Student(int age) {
        this.age = age;
    }
    public boolean equals(Object o) {
        if(!(o instanceof Student))
            return false;
        Student stu = (Student)o;
        if(stu.age == this.age) {
            return true;
        }
        return false;
    }

//    public int hashCode() {
//        return this.age * 37;
//    }
}

public class Demo1 {
    public static void main(String[] args) {
        Map<Student,String> map = new HashMap<Student,String>();
        Student s1 = new Student(12);
        Student s2 = new Student(12);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()==(s2.hashCode()));

        map.put(s1,"TestCode");

        System.out.println(map.get(s2));
    }
}



