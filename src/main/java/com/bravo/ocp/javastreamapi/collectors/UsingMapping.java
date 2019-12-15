package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UsingMapping {

  public static void main(String[] args) {

    println(Arrays.asList(NAMES));

    println(Arrays.stream(NAMES)
        .collect(Collectors.mapping(s -> s.length(), Collectors.toList() )
        )
    );

  }

}
