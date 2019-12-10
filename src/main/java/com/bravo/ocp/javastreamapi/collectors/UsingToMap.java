package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.TestDataUtils;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UsingToMap {


  public static void main(String[] args) {

    // Collection array of names into a <Name, name length> map
    println(Arrays.stream(TestDataUtils.NAMES)
        .distinct()
        .collect(Collectors.toMap(s -> s, String::length))
    );

  // Collection array of names into a <Name, occurrences> map
    println(Arrays.stream(TestDataUtils.NAMES)
        .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
    );

    // Collection array of names into a <Name, occurrences> map specifying the map type
    // Will be sort since is a TreeMap
    println(Arrays.stream(TestDataUtils.NAMES)
        .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum, () -> new TreeMap<>()))
    );

    // Collection array of names into a <Name, name length> map.
    // since names contains duplicated elements, the following code throws an exception when in tries to map a duplicated key
    try{
      println(Arrays.stream(TestDataUtils.NAMES)
          .collect(Collectors.toMap(s -> s, String::length))
      );
    } catch (IllegalStateException e){
      e.printStackTrace();
    }

    // If you expects duplicated elements, you can pass a BinaryOperator to merge the results for mappings on the same key
    // Here we want to collect into a <Name, name length> map, so our merger just returns the size of any duplicated element.
    println(Arrays.stream(TestDataUtils.NAMES)
        .collect(Collectors.toMap(s -> s, String::length, (size1, size2) -> size1))
    );

  }

}
