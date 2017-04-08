//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package net.mindview.util;
import java.util.*;

/**
 * 递归计数的通用工具，不局限于Pet类
 */
public class TypeCounter extends HashMap<Class<?>,Integer>{
  private Class<?> baseType;

  /**
   * 需要知道计数的类型
   */
  public TypeCounter(Class<?> baseType) {
    this.baseType = baseType;
  }
  public void count(Object obj) {
    Class<?> type = obj.getClass();
    /**
     * Class.isAssignableFrom()是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的父类或接口。
     */
    // 目标类型是期望类型或者子类，则计数
    if(!baseType.isAssignableFrom(type))
      throw new RuntimeException(obj + " incorrect type: "
        + type + ", should be type or subtype of "
        + baseType);
    countClass(type);
  }	
  private void countClass(Class<?> type) {
    // 获取目标类型
    Integer quantity = get(type);
    // 更新统计数
    put(type, quantity == null ? 1 : quantity + 1);
    // 获取目标类型的父类
    Class<?> superClass = type.getSuperclass();
    // 如果父类型依然在预期范围之内
    if(superClass != null &&
       baseType.isAssignableFrom(superClass))
      // 统计
      countClass(superClass);
  }
  public String toString() {
    StringBuilder result = new StringBuilder("{");
    for(Map.Entry<Class<?>,Integer> pair : entrySet()) {
      result.append(pair.getKey().getSimpleName());
      result.append("=");
      result.append(pair.getValue());
      result.append(", ");
    }
    result.delete(result.length()-2, result.length());
    result.append("}");
    return result.toString();
  }
} ///:~
