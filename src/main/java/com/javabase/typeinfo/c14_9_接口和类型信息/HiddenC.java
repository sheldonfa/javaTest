//: typeinfo/packageaccess/HiddenC.java
package com.javabase.typeinfo.c14_9_接口和类型信息;
import com.javabase.typeinfo.typeinfo.interfacea.A;

import static com.net.mindview.util.Print.*;

class C implements A {
  public void f() { print("public C.f()"); }
  public void g() { print("public C.g()"); }
  void u() { print("package C.u()"); }
  protected void v() { print("protected C.v()"); }
  private void w() { print("private C.w()"); }
}

public class HiddenC {
  public static A makeA() { return new C(); }
} ///:~
