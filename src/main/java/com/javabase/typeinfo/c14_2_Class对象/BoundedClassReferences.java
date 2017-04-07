package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/BoundedClassReferences.java

public class BoundedClassReferences {
  /**
   * ?与extends结合，创建一个范围
   */
  public static void main(String[] args) {
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;
    // Or anything else derived from Number.
  }
} ///:~
