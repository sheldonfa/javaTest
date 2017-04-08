package com.javabase.typeinfo.c14_3_类型转换前先做检查;//: typeinfo/PetCount3.java
// Using isInstance()
import java.util.*;

import com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.LiteralPetCreator;
import com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Pet;
import com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Pets;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class PetCount3 {
  static class PetCounter
  extends LinkedHashMap<Class<? extends Pet>,Integer> {
    /**
     * PetCounter预加载了所有的Pet类，这种做法不够通用
     */
    public PetCounter() {
      super(MapData.map(LiteralPetCreator.allTypes, 0));
    }

    public void count(Pet pet) {
      /**
       * 遍历所有类型，如果目标实例时该类型的实例，加1
       */
      // Class.isInstance() eliminates instanceofs:
      for(Map.Entry<Class<? extends Pet>,Integer> pair
          : entrySet())
        if(pair.getKey().isInstance(pet))
          put(pair.getKey(), pair.getValue() + 1);
    }
    public String toString() {
      StringBuilder result = new StringBuilder("{");
      for(Map.Entry<Class<? extends Pet>,Integer> pair
          : entrySet()) {
        result.append(pair.getKey().getSimpleName());
        result.append("=");
        result.append(pair.getValue());
        result.append(", ");
      }
      result.delete(result.length()-2, result.length());
      result.append("}");
      return result.toString();
    }
  }
  public static void main(String[] args) {
    PetCounter petCount = new PetCounter();
    for(Pet pet : Pets.createArray(20)) {
      printnb(pet.getClass().getSimpleName() + " ");
      petCount.count(pet);
    }
    print();
    print(petCount);
  }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*///:~
