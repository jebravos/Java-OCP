package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;
import static com.bravo.ocp.utils.TestDataUtils.WORDS;

import com.bravo.ocp.utils.PrintUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsingFlatMap {


  public static void main(String[] args) {

    Stream<List<String>> strings = Stream.of(Arrays.asList(NAMES), Arrays.asList(WORDS));

    // flat map stream of string list into one string stream
    strings
        // Only first 5 names
        .limit(5)
        .flatMap(strings1 -> strings1.stream()
            // Only first 5 words
            .limit(5)
        ).forEach(PrintUtils::println);
    // or
    // strings.flatMap(ss -> ss.stream()).forEach(PrintUtils::println);

    println("----------------");
    //flat map stream of strings into a stream of characters, only the 2 first characters of each name
    Stream.of(NAMES)
        .flatMap(name -> Stream.of(name.split(""))
            .limit(2)
        ).forEach(PrintUtils::println);


  }

}
