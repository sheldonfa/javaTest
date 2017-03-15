package com.javabase.extend;

/**
 * @author fangxin
 * @date 2017/2/19.
 */

class Person{

    String id;

    public Person(String id) {
        this.id = id;
    }

    public static void say(){
        System.out.println("Person");
    }
}

class Student extends Person{

    String id;

    public Student(String id) {
        /**
         * 父类没有默认构造函数，必须手动调用
         */
        super(id);
        this.id = id;
    }

    public static void say(){
        System.out.println("student");
    }
}

public class Client1 {
    public static void main(String[] args) {

        Student student = new Student("123");
        System.out.println(student.id);
    }
}