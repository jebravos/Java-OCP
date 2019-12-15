package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingSummarizingInt {


  public static void main(String[] args) {

    println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
//        .collect(Collectors.mapping(i -> i, Collectors.summarizingInt(i-> i));
        // same as
            .collect(Collectors.summarizingInt(i -> i))
    );

    println("sum = {}", Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
            .collect(Collectors.summarizingInt(i -> i))
            .getSum()
    );

    println("average = {}", Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
        .collect(Collectors.summarizingInt(i -> i))
        .getAverage()
    );

  }

}
