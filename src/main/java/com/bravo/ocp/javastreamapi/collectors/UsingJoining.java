package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingJoining {


  public static void main(String[] args) {

    println(() -> Stream.of(NAMES)
        .distinct()
        .collect(Collectors.joining())
    );

    println(() -> Stream.of(NAMES)
        .distinct()
        .collect(Collectors.joining(", "))
    );

    println(() -> Stream.of(NAMES)
        .distinct()
        .collect(Collectors.joining(", ", "$ ", " %"))
    );


  }

}
