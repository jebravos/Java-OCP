package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private final String[] names = new String[]{"Jorge", "Esteban", "Maria", "Camila", "Diana", "Patricia", "Paula", "Jose", "Esteban", "Patricia"};

    public static void main(String[] args) {
        Streams s = new Streams();
        s.testCount();
        s.testStreamMap();
    }

    private void testCount() {
        Stream sNames = Stream.of(names);
        println("Names has: " + sNames.count() + " elements");
        println("Empty stream has: " + Stream.empty().count() + " elements");
        println("---------------------------------------------------");
    }

    private void testStreamMap() {
        Stream<String> sNames = Stream.of(names);
        //map to string size
        List<Integer> namesLenght =  sNames.map(String::length).collect(Collectors.toList());
        println("Names lengths: " + namesLenght);
        //Find the max length
        Stream<String> sNames2 = Stream.of(names);
        println("Max length : " + sNames2.map(String::length).max(Integer::compareTo));
        println("---------------------------------------------------");
    }


}
