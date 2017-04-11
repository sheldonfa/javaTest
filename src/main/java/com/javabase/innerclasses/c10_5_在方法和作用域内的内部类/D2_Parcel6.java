package com.javabase.innerclasses.c10_5_在方法和作用域内的内部类;//: innerclasses/Parcel6.java
// Nesting a class within a scope.

public class D2_Parcel6 {
  private void internalTracking(boolean b) {
    if(b) {
      /**
       * 一个定义在作用域内的类，而这个作用域在方法的内部
       * 在作用域之外，该类是不可用的
       */
      class TrackingSlip {
        private String id;
        TrackingSlip(String s) {
          id = s;
        }
        String getSlip() { return id; }
      }
      TrackingSlip ts = new TrackingSlip("slip");
      String s = ts.getSlip();
    }
    // Can't use it here! Out of scope:
    //! TrackingSlip ts = new TrackingSlip("x");
  }	
  public void track() { internalTracking(true); }
  public static void main(String[] args) {
    D2_Parcel6 p = new D2_Parcel6();
    p.track();
  }
} ///:~
