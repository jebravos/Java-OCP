package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class UsingAllMatchAnyMatch {

  public static void main(String[] args) {

    Predicate<String> hasSize5 = name -> name.length() == 5;
    // Any match and allMatch are terminal operations
    // the stream will be close after its execution
    println("There are any name with size 5 {}", Stream.of(NAMES).anyMatch(hasSize5));
    println("all names has size 5 {}", Stream.of(NAMES).allMatch(hasSize5));

  }

}
