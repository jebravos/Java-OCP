package com.bravo.ocp.AdvanceClassDesign.inner_classes.otherpackage;

import static com.bravo.ocp.utils.PrintUtils.println;

public class MyClassWithStaticInnerClass {

  public class InnerClass{
    private int a;
    protected int b;
    public int c;
  }

  public static class MyStaticInnerClass{

    public static void main(String[] args) {
      InnerClass ic = new MyClassWithStaticInnerClass().new InnerClass();
      println(ic.a = 10);
      println(ic.b = 100);
    }

  }

}
