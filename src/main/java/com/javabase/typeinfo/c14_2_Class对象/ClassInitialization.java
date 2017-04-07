package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/ClassInitialization.java
import java.util.*;

class Initable {
  static final int staticFinal = 47;
  static final int staticFinal2 =
    ClassInitialization.rand.nextInt(1000);
  static {
    System.out.println("Initializing Initable");
  }
}

class Initable2 {
  static int staticNonFinal = 147;
  static {
    System.out.println("Initializing Initable2");
  }
}

class Initable3 {
  static int staticNonFinal = 74;
  static {
    System.out.println("Initializing Initable3");
  }
}

public class ClassInitialization {
  public static Random rand = new Random(47);
  public static void main(String[] args) throws Exception {
    /**
     * 单单使用.class引用不会引起初始化
     */
    Class initable = Initable.class;
    System.out.println("After creating Initable ref");
    /**
     * 编译器常量的读取，不需要初始化
     */
    // Does not trigger initialization:
    System.out.println(Initable.staticFinal);
    /**
     * 如果读取的不是编译器常量，就需要初始化（貌似与读取的内容无关）
     */
    // Does trigger initialization:
    System.out.println(Initable.staticFinal2);
    /**
     * 如果常量不是final的，总是触发
     */
    // Does trigger initialization:
    System.out.println(Initable2.staticNonFinal);
    /**
     * class.forname必然初始化
     */
    Class initable3 = Class.forName("com.javabase.typeinfo.c14_2_Class对象.Initable3");
    System.out.println("After creating Initable3 ref");
    System.out.println(Initable3.staticNonFinal);
  }
} /* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*///:~
