package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.Comparator;
import java.util.stream.Stream;

public class UsingReduction {


  public static void main(String[] args) {


    // Stream.max needs a comparator
    Stream.of(1,2,3,4,5,6)
        .max(Comparator.naturalOrder()).ifPresent(max -> println("max= {}", max));

    Stream.of(1,2,3,4,5,6)
        // Since we didn't use an "identity" in the reduce method, an Optional is returned
        .reduce(Integer::sum)
        .ifPresent(sum -> println("sum of elements = {}", sum));

    PrintUtils.println("sum of elements = {} ", Stream.of(1,2,3,4,5,6)
        // reduce with T reduce(T identity, BinaryOperator<T> accumulator);
        // No optional is returned but an Integer since we use 0 as identity
        .reduce(0, Integer::sum));

    PrintUtils.println("sum of elements = {} ", Stream.of(1,2,3,4,5,6)
        // reduce with <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
        .reduce(0, Integer::sum, Integer::sum));

  }

}
