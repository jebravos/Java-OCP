package com.bravo.ocp.AdvanceClassDesign;

import static com.bravo.ocp.utils.PrintUtils.println;

public class PrivateMembers {

  //private means private to the class and not to the object
  // this means private members can't be accessed from any  class other than the class it was declared
  private int privateI;

  private void privateMethod(){
    println("Hello from private method");
  }

  public void modifyOther(PrivateMembers other){
    other.privateI = 20;
  }

  public void useOtherPrivateMethod(PrivateMembers other){
    other.privateMethod();
  }
}


class Sub extends PrivateMembers{

  @Override
  public void modifyOther(PrivateMembers other) {
    // private members can only be accessed in the class that they were defined
    // other.privateI = 20;
  }

  public void aMethod(){
    // Trying to access a private method or variable in the Parent class makes the class not compile
    // Sub classes don't inherit private members
    // privateMethod();
    // privateI = 20;
  }

}


