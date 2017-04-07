package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/WildcardClassReferences.java

public class WildcardClassReferences {

  /**
   * 通配符“?”，表示任何事物
   * Class<？>优于平凡的Class，即便它们等价
   */
  public static void main(String[] args) {
    Class<?> intClass = int.class;
    intClass = double.class;
  }
} ///:~
