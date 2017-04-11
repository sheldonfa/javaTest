package com.javabase.innerclasses.c10_1_创建内部类;//: innerclasses/Parcel1.java
// Creating inner classes.

/**
 * 内部类就是定义在类的内部的类，当然这不是唯一的区别
 */
public class D1_Parcel1 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) {
      label = whereTo;
    }
    String readLabel() { return label; }
  }	
  // Using inner classes looks just like
  // using any other class, within Parcel1:
  public void ship(String dest) {
    Contents c = new Contents();
    Destination d = new Destination(dest);
    System.out.println(d.readLabel());
  }
  public static void main(String[] args) {
    D1_Parcel1 p = new D1_Parcel1();
    p.ship("Tasmania");
  }
} /* Output:
Tasmania
*///:~
