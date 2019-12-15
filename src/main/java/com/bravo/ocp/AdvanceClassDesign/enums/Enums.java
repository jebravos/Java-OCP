package com.bravo.ocp.AdvanceClassDesign.enums;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.Arrays;

public class Enums {

  public static void main(String[] args) {

    Numbers.printA();
    Numbers.printA();
    println(Arrays.asList(Numbers.values()));


    // natural order of Enum elements is the declaration order
    Arrays.asList(Numbers.values())
        .stream()
        .max(Enum::compareTo)
        .ifPresent(max -> println("max: {}", max));

    Arrays.asList(Numbers.values())
        .stream()
        .min(Enum::compareTo)
        .ifPresent(min -> println("min: {}", min));

  }
}


enum Numbers {
  ONE, THREE, TWO;

  public static String a = "a";

  Numbers() {
//     a = "b"; //It's illegal to use static variables from enums constructor
  }

  public static void printA() {
    println(a);
  }
}
