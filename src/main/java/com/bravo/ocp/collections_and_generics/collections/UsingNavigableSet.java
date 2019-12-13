package com.bravo.ocp.collections_and_generics.collections;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class UsingNavigableSet {


  public static void main(String[] args) {

    NavigableSet<Integer> ints = new TreeSet<>();
    IntStream.rangeClosed(300, 308).forEach(ints::add);
    println("ints: {}", ints);

    // subset creates a view of the portion of ints set.
    NavigableSet<Integer> subs = ints.subSet(305, true, 308, true);
    println("subs : {}", subs);

    // ints and subs are backed by the same original set, so any modification on subs will affect ints as well.
    subs.remove(307);
    println("ints : {}", ints);
    println("subs : {}", subs);

    // since 309 it's not in the range defined for the subs set (305 - 308), IllegalArgumentException will be thrown
    try{
      subs.add(309);
    } catch (IllegalArgumentException e){
      e.printStackTrace();
    }

  }

}
