package com.bravo.ocp.AdvanceClassDesign.inner_classes;

import static com.bravo.ocp.utils.PrintUtils.println;

public class UsingAnonymousInnerClasses {


  // This anonymous class extends from AnAbstractClass
  AnAbstractClass impl = new AnAbstractClass() {
    @Override
    public void test() {
      println("Hello world");
    }
  };

  public static void main(String[] args) {

    UsingAnonymousInnerClasses main = new UsingAnonymousInnerClasses();
    main.impl.test();

  }

}

abstract class AnAbstractClass {
  public abstract void test();
}
