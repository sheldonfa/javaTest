package com.javabase.innerclasses.c10_3_使用点this和点new;//: innerclasses/Parcel3.java
// Using .new to create instances of inner classes.

public class D3_Parcel3 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) { label = whereTo; }
    String readLabel() { return label; }
  }
  public static void main(String[] args) {
    D3_Parcel3 p = new D3_Parcel3();
    /**
     * 再次举例必须使用外部类的实例 来创建 内部类对象
     *
     * 在拥有外部类对象之前，是不可能创建内部类对象的。因为内部类对象会暗暗包含外部类对象的引用。
     * 注意：嵌套类（静态内部类）除外。它不需要外部类对象的引用
     */
    // Must use instance of outer class
    // to create an instance of the inner class:
    Contents c = p.new Contents();
    Destination d = p.new Destination("Tasmania");
  }
} ///:~
