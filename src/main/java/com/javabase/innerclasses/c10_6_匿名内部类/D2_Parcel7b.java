package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/Parcel7b.java
// Expanded version of Parcel7.java

import com.javabase.innerclasses.c10_4_内部类与向上转型.Contents;

/**
 * 该例是对Parcel7的非匿名内部类形式的写法
 */
public class D2_Parcel7b {
  class MyContents implements Contents {
    private int i = 11;
    public int value() { return i; }
  }

  public Contents contents() { return new MyContents(); }
  public static void main(String[] args) {
    D2_Parcel7b p = new D2_Parcel7b();
    Contents c = p.contents();
  }
} ///:~
