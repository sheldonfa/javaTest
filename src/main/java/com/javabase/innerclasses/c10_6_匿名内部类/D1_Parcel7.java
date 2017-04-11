package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

import com.javabase.innerclasses.c10_4_内部类与向上转型.Contents;

public class D1_Parcel7 {
  /**
   * Contents是个接口
   */
  public Contents contents() {
    /**
     * 你准备创建一个接口对象吗？
     * 在到达分号之前，你突然说：“等一等，我想在这里插入一个类的定义。”
     */
    return new Contents() { // Insert a class definition
      /**
       * 这里其实使用了默认构造器生成Contents
       */
      private int i = 11;
      public int value() { return i; }
    }; // Semicolon required in this case
  }
  public static void main(String[] args) {
    D1_Parcel7 p = new D1_Parcel7();
    Contents c = p.contents();
  }
} ///:~
