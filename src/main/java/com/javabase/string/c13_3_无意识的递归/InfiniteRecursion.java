package com.javabase.string.c13_3_无意识的递归;//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}
import java.util.*;

public class InfiniteRecursion {
  public String toString() {
//    return " InfiniteRecursion address: " + this + "\n";
    return " InfiniteRecursion address: " + super.toString() + "\n";
  }
  public static void main(String[] args) {
    List<InfiniteRecursion> v =
      new ArrayList<InfiniteRecursion>();
    for(int i = 0; i < 10; i++)
      v.add(new InfiniteRecursion());
    /**
     * 打印调用toString，toString中又将this强转成字符串，怎么强转呢？调用toString，结果递归了
     *
     * 想要打印对象的内存地址，应该用super.toString()
     */
    System.out.println(v);
  }
} ///:~
