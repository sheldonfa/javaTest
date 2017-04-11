package com.javabase.innerclasses.innerclasses;//: innerclasses/Parcel7b.java
// Expanded version of Parcel7.java

import com.javabase.innerclasses.c10_4_内部类与向上转型.Contents;

public class Parcel7b {
  class MyContents implements Contents {
    private int i = 11;
    public int value() { return i; }
  }
  public Contents contents() { return new MyContents(); }
  public static void main(String[] args) {
    Parcel7b p = new Parcel7b();
    Contents c = p.contents();
  }
} ///:~
