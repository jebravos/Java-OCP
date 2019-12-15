package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingReductionForIntStream {

  public static void main(String[] args) {

    // Notice that reduce returns an OptionalInt
    OptionalInt sum1 = IntStream.of(1, 2, 3, 4, 5, 6)
        .reduce((a, b) -> a + b);
    println(sum1.orElse(0));

    // This version of reduce uses an "identity"
    // identity will be used with the first element on the stream
    Integer sum = IntStream.of(1, 2, 3, 4, 5, 6)
        .reduce(0, (a, b) -> a + b);
    println(sum);

    Integer sum0 = IntStream.of()
        .reduce(0, (a, b) -> a + b);
    println(sum0);

    //IntStream and similar contains specific reduction functions such as:

    // IntStream.max doesn't need a comparator, since int are comparable
    IntStream.of(1,2,3,4,5,6).max().ifPresent(PrintUtils::println);

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
