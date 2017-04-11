package com.javabase.innerclasses.c10_5_在方法和作用域内的内部类;//: innerclasses/Parcel5.java
// Nesting a class within a method.

import com.javabase.innerclasses.c10_4_内部类与向上转型.Destination;

public class D1_Parcel5 {
  public Destination destination(String s) {
    /**
     * 一个定义在方法中的类
     * 在destination之外是不能被访问的
     */
    class PDestination implements Destination {
      private String label;
      private PDestination(String whereTo) {
        label = whereTo;
      }
      public String readLabel() { return label; }
    }
    return new PDestination(s);
  }
  public static void main(String[] args) {
    D1_Parcel5 p = new D1_Parcel5();
    Destination d = p.destination("Tasmania");
  }
} ///:~
