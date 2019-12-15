package com.bravo.ocp.AdvanceClassDesign.interfaces;

import static com.bravo.ocp.utils.PrintUtils.println;

interface Eatable {

  int types = 10;
}

class Food implements Eatable {

  public static int types = 20;
}

public class Fruit extends Food implements Eatable {  //LINE1

  public static void main(String[] args) {
    //Ambiguous reference
    // Remove comment lines and compile to see the error
    //    types = 30; //LINE 2
    //    println(types); //LINE 3
  }
}

