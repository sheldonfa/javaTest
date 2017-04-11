package com.javabase.innerclasses.c10_3_使用点this和点new;//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

public class D2_DotNew {
  public class Inner {}
  public static void main(String[] args) {
    D2_DotNew dn = new D2_DotNew();
    /**
     * 创建内部类对象必须使用外部类对象 而不是仅仅外部类名
     */
    Inner dni = dn.new Inner();
  }
} ///:~
