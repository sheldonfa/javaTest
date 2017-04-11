package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/Parcel10.java
// Using "instance initialization" to perform
// construction on an anonymous inner class.

import com.javabase.innerclasses.c10_4_内部类与向上转型.Destination;

public class D6_Parcel10 {
  public Destination
  destination(final String dest, final float price) {
    /**
     * 包含 实例初始化 的例子
     * 参数类型 由于匿名内部类中直接使用了，所以要final
     *
     * 匿名内部类和继承有区别：匿名内部类可以扩展类，也可以实现接口，但是不能兼备，而且接口也只能实现一个。
     */
    return new Destination() {
      private int cost;
      // Instance initialization for each object:
      {
        /**
         * 实例初始化不能重载，所以你只能有一个这样的“构造器”
         */
        cost = Math.round(price);
        if(cost > 100)
          System.out.println("Over budget!");
      }
      private String label = dest;
      public String readLabel() { return label; }
    };
  }	
  public static void main(String[] args) {
    D6_Parcel10 p = new D6_Parcel10();
    Destination d = p.destination("Tasmania", 101.395F);
  }
} /* Output:
Over budget!
*///:~
