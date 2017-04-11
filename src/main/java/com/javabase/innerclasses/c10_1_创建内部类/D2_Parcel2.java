package com.javabase.innerclasses.c10_1_创建内部类;//: innerclasses/Parcel2.java
// Returning a reference to an inner class.

/**
 * 如果想从外部类的非静态方法之外的任何位置创建某个内部类的对象，那么必须具体指明这个对象的类型
 */
public class D2_Parcel2 {
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
  public Destination to(String s) {
    return new Destination(s);
  }
  public Contents contents() {
    return new Contents();
  }
  public void ship(String dest) {
    /**
     * 非静态方法内部，可以直接使用Contents
     */
    Contents c = contents();
    Destination d = to(dest);
    System.out.println(d.readLabel());
  }
  public static void main(String[] args) {
    D2_Parcel2 p = new D2_Parcel2();
    p.ship("Tasmania");
    D2_Parcel2 q = new D2_Parcel2();
    /**
     * main方法中好像可以不用具体指明
     */
    // Defining references to inner classes:
    Contents c = q.contents();
    Destination d = q.to("Borneo");
  }
} /* Output:
Tasmania
*///:~
