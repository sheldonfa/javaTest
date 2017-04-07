//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package com.javabase.typeinfo.c14_3_类型转换前先做检查.pets;

import java.util.*;

public class Pets {
  public static final PetCreator creator =
    new LiteralPetCreator();
  public static Pet randomPet() {
    return creator.randomPet();
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
} ///:~
