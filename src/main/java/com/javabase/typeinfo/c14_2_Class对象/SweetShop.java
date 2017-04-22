package com.javabase.typeinfo.c14_2_Class对象;//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static com.net.mindview.util.Print.*;

class Candy {
  static { print("Loading Candy"); }
}

class Gum {
  static { print("Loading Gum"); }
}

class Cookie {
  static { print("Loading Cookie"); }
}

public class SweetShop {
  public static void main(String[] args) {
    print("inside main");
    new Candy();
    print("After creating Candy");
    try {
      /**
       * Class.forName 返回Class对象的引用
       * 副作用：如果该类还没有被加载就加载它
       * 注意：全限定名称
       */
//      Class.forName("Gum");
      Class.forName("com.javabase.typeinfo.c14_2_Class对象.Gum");
    } catch(ClassNotFoundException e) {
      print("Couldn't find Gum");
    }
    print("After Class.forName(\"Gum\")");
    new Cookie();
    print("After creating Cookie");
  }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
