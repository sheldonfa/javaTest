package com.javabase.innerclasses.c10_6_匿名内部类;//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.
import static net.mindview.util.Print.*;

abstract class Base {
  public Base(int i) {
    print("Base constructor, i = " + i);
  }
  public abstract void f();
}	

public class D5_AnonymousConstructor {
  /**
   * 匿名内部类没有名字，构造器怎么创建？通过 实例初始化 达到效果
   *
   * 这里的i可以不是final的，因为匿名类内部没有直接使用，而是传递给了基类的构造器
   */
  public static Base getBase(int i) {
    return new Base(i) {
      { print("Inside instance initializer"); }
      public void f() {
        print("In anonymous f()");
      }
    };
  }
  public static void main(String[] args) {
    Base base = getBase(47);
    base.f();
  }
} /* Output:
Base constructor, i = 47
Inside instance initializer
In anonymous f()
*///:~
