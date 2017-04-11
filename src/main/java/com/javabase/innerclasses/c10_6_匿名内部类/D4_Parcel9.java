package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.

import com.javabase.innerclasses.c10_4_内部类与向上转型.Destination;

public class D4_Parcel9 {
  // Argument must be final to use inside
  // anonymous inner class:

  /**
   * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，
   * 那么编译期要求其参数引用是final的，否则编译时期报错。
   */
  public Destination destination(final String dest) {
    return new Destination() {
      private String label = dest;
      public String readLabel() { return label; }
    };
  }
  public static void main(String[] args) {
    D4_Parcel9 p = new D4_Parcel9();
    Destination d = p.destination("Tasmania");
  }
} ///:~
