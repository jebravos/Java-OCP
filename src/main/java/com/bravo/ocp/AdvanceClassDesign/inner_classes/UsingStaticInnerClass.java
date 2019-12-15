package com.bravo.ocp.AdvanceClassDesign.inner_classes;


// Static inner classes can be imported with static imports
import static com.bravo.ocp.AdvanceClassDesign.inner_classes.otherpackage.MyClassWithStaticInnerClass.MyStaticInnerClass;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.AdvanceClassDesign.inner_classes.otherpackage.MyClassWithStaticInnerClass;

public class UsingStaticInnerClass {

  //
  MyStaticInnerClass myStaticInnerClass = new MyStaticInnerClass();

  public static void main(String[] args) {

    UsingStaticInnerClass main = new UsingStaticInnerClass();

    MyClassWithStaticInnerClass myClassWithStaticInnerClass = new MyClassWithStaticInnerClass();
    MyClassWithStaticInnerClass.InnerClass ic = myClassWithStaticInnerClass.new InnerClass();
//    println(ic.a); // cannot be accessed since private
//    println(ic.b); // cannot be accessed since protected and not in the same package nor subclass
    println(ic.c); //ok cuz public
  }

}


