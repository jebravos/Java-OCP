package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCounting {

  public static void main(String[] args) {

    Long count = Stream.of(1,2,3,4,5,6)
        .collect(Collectors.counting());
    // same as
    Long count2 = Stream.of(1, 2, 3, 4, 5, 6).count();

    println(count);
    println(count2);


  }

}
