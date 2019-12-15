package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.function.BiFunction;

public class UseBiFunction {

  public static void main(String[] args) {
    BiFunction<Integer, Boolean, String> bfun = (i, b) -> "hello " + i + " " + b;
    println(bfun.apply(1, Boolean.TRUE));
  }

}
