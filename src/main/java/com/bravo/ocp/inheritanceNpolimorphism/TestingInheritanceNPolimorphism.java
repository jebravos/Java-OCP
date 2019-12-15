package com.bravo.ocp.inheritanceNpolimorphism;

import static com.bravo.ocp.utils.PrintUtils.println;

public class TestingInheritanceNPolimorphism {


  public static void main(String[] args) {
    C c = new C("my c");
    B b = new B();

    println(c.i);
    println(b.i);
  }

}

class A {

  protected int i = 1;

  public A() {
  } // A1

  public A(String s) {
    this();
    println("A :" + s);
  }  // A2
}

class B extends A {

  // This is not a constructor but a method
  public int B(String s) {
    println("B :" + s);
    return 0;
  } // B1
}

class C extends B {

  int i = 20;

  private C() {
    super();
  } // C1

  public C(String s) {
    this();
    println("C :" + s);
  } // C2

  public C(int i) {
  } // C3
}

