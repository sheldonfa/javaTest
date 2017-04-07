//: typeinfo/toys/GenericToyTest.java
// Testing class Class.
package com.javabase.typeinfo.c14_2_Class对象;

import com.javabase.typeinfo.c14_2_Class对象.FancyToy;

public class GenericToyTest {
    /**
     * 泛化的Class对象，使用newInstance时返回该对象的确切类型
     */
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        /**
         * getSuperclass()返回的是FancyToy的超类，但不接受Class<Toy>这样的声明
         */
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won't compile:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        /**
         * 返回类型也只能是Object
         */
        Object obj = up.newInstance();
    }
} ///:~
