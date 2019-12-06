package com.bravo.ocp.AdvanceClassDesign;

import static com.bravo.ocp.utils.PrintUtils.println;

public class Overriding2 {

  public static void main(String[] args) {
    A o1 = new B(); //3
    A o2 = new A();
    o1.mA(); //4

    // This line wont compile since A has not a method mB()
    // o1.mB(); //5
    o2.mA();
    
    println(o1.a);
    // This wont compile since a has a private accessor modifier in B
    // println(((B)o1).a);

    ((B)o1).mB();

  }
}

class A {

  protected final int a = 10;

  final void mA() {
    println("In A.mA " + a);
  }

}

class B extends A {

  // Variables are not overriden, they're just hidden or shadowed
  private int a = 100;

  void mB() {
    println("In B.mB " + a);
  }

  // this method cannot be overriden since it is declared as final in the super class A
  //  void mA() { //2
  //    println("In B.mA " + a);
  //  }
}


