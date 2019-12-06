package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingPartitioningBy{


  public static void main(String[] args) {

    // partitioningBy expects a predicate and returns a collector which distributes the elements in 2 groups
    // One containing the elements for which the predicate returns TRUE and another for the elements which the predicate returns FALSE
    Map<Boolean, List<String>> map = Stream.of(NAMES).distinct()
        .collect(Collectors.partitioningBy(s -> s.startsWith("P")));

    println(map);

    Map<Boolean, Map<Object, List<String>>> map2 = Stream.of(NAMES).distinct()
        .collect(Collectors.partitioningBy(s -> s.startsWith("P"), Collectors.groupingBy(s -> s.charAt(0))));

    println(map2);

  }

}
