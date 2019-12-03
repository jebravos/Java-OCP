package com.bravo.ocp.functional;

import java.util.function.BiFunction;

public class UseBiFunction {

  public static void main(String[] args) {
    BiFunction<String, String, String> bfun = (s, s2) -> "hello";
  }

}
