//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package com.javabase.generics.generics.coffee;
import java.util.*;

import generics.coffee.*;
import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Cappuccino;
import generics.coffee.Coffee;
import generics.coffee.Mocha;
import net.mindview.util.*;

public class CoffeeGenerator
implements Generator<generics.coffee.Coffee>, Iterable<generics.coffee.Coffee> {
  private Class[] types = { generics.coffee.Latte.class, Mocha.class,
    Cappuccino.class, Americano.class, Breve.class, };
  private static Random rand = new Random(47);
  public CoffeeGenerator() {}
  // For iteration:
  private int size = 0;
  public CoffeeGenerator(int sz) { size = sz; }	
  public generics.coffee.Coffee next() {
    try {
      return (generics.coffee.Coffee)
        types[rand.nextInt(types.length)].newInstance();
      // Report programmer errors at run time:
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  class CoffeeIterator implements Iterator<generics.coffee.Coffee> {
    int count = size;
    public boolean hasNext() { return count > 0; }
    public generics.coffee.Coffee next() {
      count--;
      return CoffeeGenerator.this.next();
    }
    public void remove() { // Not implemented
      throw new UnsupportedOperationException();
    }
  };	
  public Iterator<generics.coffee.Coffee> iterator() {
    return new CoffeeIterator();
  }
  public static void main(String[] args) {
    CoffeeGenerator gen = new CoffeeGenerator();
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
    for(Coffee c : new CoffeeGenerator(5))
      System.out.println(c);
  }
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
