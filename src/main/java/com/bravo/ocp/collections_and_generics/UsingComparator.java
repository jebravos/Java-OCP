package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.Comparator;
import java.util.stream.Stream;

public class UsingComparator {


  public static void main(String[] args) {

    final String[] names = new String[]{"Pedro", "Cain","Victor", "Jorge", "Esteban", "Maria", "Camila", "Diana", "Patricia", "Paula", "Jose", "Esteban", "Patricia"};

    Comparator<String> alphabetic = String::compareTo;
    // comparingInt will compute a sort int key to use in the returned comparator
    Comparator<String> byLength = Comparator.comparingInt(String::length);
    // or
    // Comparator<String> byLength = (o1, o2) -> o1.length() - o2.length();


    Stream.of(names)
        // Sort by length then by alphabetic order
        .sorted(byLength
        // We can chain with thenComparing(Comparator)
        .thenComparing(alphabetic))
        .forEach(PrintUtils::println);

    println("---------------");

    Stream.of(names)
        // comparing expects a function to extract a sort key and return a comparator that will use that key to compare elements
        // In this case, we use s -> s.length, so the comparator will use the length as key to compare the elements on the stream
        // So we will have elements order by length
        .sorted(Comparator.comparing(String::length))
        .forEach(PrintUtils::println);

    println("---------------");
  }


}
