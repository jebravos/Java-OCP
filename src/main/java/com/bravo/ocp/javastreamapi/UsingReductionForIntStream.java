package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class UsingReductionForIntStream {

  public static void main(String[] args) {

    //IntStream and similar contains specific reduction functions such as:

    println("sum of elements = {}", Stream.of(1,2,3,4,5,6)
        .mapToInt(value -> value)
        // sum
        .sum());

    println("count of elements = {}", Stream.of(1,2,3,4,5,6)
        .mapToInt(value -> value)
        // count
        .count());

    // REMEMBER!!! average return an OptionalDouble
    OptionalDouble average = Stream.of(1, 2, 3, 4, 5, 6)
        .mapToInt(value -> value)
        .average();
    println("average of elements = {}", average);
    println("REMEMBER!!! average return an OptionalDouble, so to get its value you should use average.getAsDouble() = {}", average.getAsDouble());


    // Bonus!
    // forEachOrdered process the elements in order
    Stream.of(1,2,3,4,5,6)
        .mapToInt(value -> value)
        .unordered()
        .forEachOrdered(PrintUtils::println);

  }

}
