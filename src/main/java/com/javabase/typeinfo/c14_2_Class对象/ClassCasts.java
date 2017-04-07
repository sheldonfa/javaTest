package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/ClassCasts.java

class Building {}
class House extends Building {}

public class ClassCasts {
  public static void main(String[] args) {
    // b实际是House，父类是Building
    Building b = new House();
    Class<House> houseType = House.class;
    // SE5新特性强转。在无法使用普通强转的情况下显得有用，如编写泛型代码
    House h = houseType.cast(b);
    // 强转也可以
    h = (House)b; // ... or just do this.
  }
} ///:~
