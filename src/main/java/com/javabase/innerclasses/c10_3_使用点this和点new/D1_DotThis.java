package com.javabase.innerclasses.c10_3_使用点this和点new;//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.

public class D1_DotThis {
  void f() { System.out.println("DotThis.f()"); }
  public class Inner {
    public D1_DotThis outer() {
      /**
       * 内部类的名字后面跟上.this可以生成对外部类对象的引用
       */
      return D1_DotThis.this;
      // A plain "this" would be Inner's "this"
    }
  }
  public Inner inner() { return new Inner(); }
  public static void main(String[] args) {
    D1_DotThis dt = new D1_DotThis();
    Inner dti = dt.inner();
    dti.outer().f();
  }
} /* Output:
DotThis.f()
*///:~
