package com.demo.pojo;

/**
 * @author fangxin
 * @date 2016/12/29.
 */
public class Client {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        abc(student1, student2);

    }

    private static void abc(Student student1, Student student2) {
        student1.username = null;
        System.out.println(student2.username);
    }
}
