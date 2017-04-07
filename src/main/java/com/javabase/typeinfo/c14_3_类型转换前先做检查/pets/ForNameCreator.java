//: typeinfo/pets/ForNameCreator.java
package com.javabase.typeinfo.c14_3_类型转换前先做检查.pets;

import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Mutt",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Pug",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.EgyptianMau",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Manx",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Cymric",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Rat",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Mouse",
    "com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
