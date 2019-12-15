package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

public class TrickyFunctionalInterfaces {

  public static void main(String[] args) {
    // Since Tricky is a functional interface, we can create an implementation using lambda
    Tricky t = () -> println("undoing trick");
    // Will execute the default method ddo() in Tricky
    t.ddo();
    // Will execute our lamda
    t.undo();
  }

}


//This is a functional interface since it has only one abstract method
@FunctionalInterface
interface Tricky{

  default void ddo(){
    println("from default ddo");
  }

  void undo();
}
