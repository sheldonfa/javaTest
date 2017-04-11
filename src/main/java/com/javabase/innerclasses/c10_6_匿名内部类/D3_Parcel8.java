package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/Parcel8.java
// Calling the base-class constructor.

public class D3_Parcel8 {
  public Wrapping wrapping(int x) {
    // Base constructor call:
    /**
     * 如果基类需要的是有参的构造器，匿名内部类怎么定义？
     */
    return new Wrapping(x) { // Pass constructor argument.
      public int value() {
        return super.value() * 47;
      }
    }; // Semicolon required
  }
  public static void main(String[] args) {
    D3_Parcel8 p = new D3_Parcel8();
    Wrapping w = p.wrapping(10);
  }
} ///:~
