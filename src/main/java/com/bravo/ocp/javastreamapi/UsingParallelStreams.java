package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class UsingParallelStreams {


  public static void main(String[] args) {

    IntStream.range(0, Integer.MAX_VALUE)
        .parallel()
        .filter(value -> value%2==0)
        .limit(10)
        // Order is not assured since the stream may be split in multiple streams
        .forEach(PrintUtils::println);

    println("------------------");

    IntStream.range(0, Integer.MAX_VALUE)
        .parallel()
        .filter(value -> value%2==0)
        .limit(10)
        // Order is now assured
        .sequential()
        .forEach(PrintUtils::println);
    println("------------------");

    println(IntStream.range(0, Integer.MAX_VALUE)
        .parallel()
        .filter(value -> value%2==0)
        .limit(12)
        .allMatch(value -> value < 20));

  }

}
