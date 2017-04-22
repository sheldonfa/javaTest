package com.javabase.typeinfo.c14_3_类型转换前先做检查;//: typeinfo/PetCount4.java
import com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Pet;
import com.javabase.typeinfo.c14_3_类型转换前先做检查.pets.Pets;
import com.net.mindview.util.TypeCounter;
import com.net.mindview.util.*;
import static com.net.mindview.util.Print.*;

public class PetCount4 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Pet.class);
    for(Pet pet : Pets.createArray(20)) {
      printnb(pet.getClass().getSimpleName() + " ");
      counter.count(pet);
    }
    print();
    print(counter);
  }
} /* Output: (Sample)
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Mouse=2, Dog=6, Manx=7, EgyptianMau=2, Rodent=5, Pug=3, Mutt=3, Cymric=5, Cat=9, Hamster=1, Pet=20, Rat=2}
*///:~
