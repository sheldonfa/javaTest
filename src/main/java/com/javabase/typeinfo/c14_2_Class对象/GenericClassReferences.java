package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/GenericClassReferences.java

public class GenericClassReferences {
  public static void main(String[] args) {
    /**
     * 没有泛化的class对象引用，可以指向任何class对象
     */
    Class intClass = int.class;
    /**
     * 泛化的class引用，不能指向其他类型class对象。
     * 注意：Integer是Number的子类，但是Integer Class不是Number Class子类
     */
    Class<Integer> genericIntClass = int.class;
    genericIntClass = Integer.class; // Same thing
    intClass = double.class;
//     genericIntClass = double.class; // Illegal
  }
} ///:~
