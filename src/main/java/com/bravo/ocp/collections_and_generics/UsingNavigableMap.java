package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.util.NavigableMap;
import java.util.TreeMap;

public class UsingNavigableMap {


  public static void main(String[] args) {

    NavigableMap<Integer, String> navigableMap = new TreeMap<>();
    navigableMap.put(1, "a");
    navigableMap.put(4, "d");
    navigableMap.put(3, "C");
    navigableMap.put(2, "b");
    navigableMap.put(5, "e");
    navigableMap.put(6, "f");
    navigableMap.put(7, "g");

    // Since is a navigableMap, elements will be sorted by key
    printMap(navigableMap, "navigableMap");
    // This will retrieves and removes the first element on the map
    println("navigableMap.pollFirstEntry() -> {}",navigableMap.pollFirstEntry());
    printMap(navigableMap, "navigableMap");
    // This will retrieves and removes the last element on the map
    println("navigableMap.pollLastEntry() ->  {}",navigableMap.pollLastEntry());
    printMap(navigableMap, "navigableMap");

    // This returns a view of  a portion of navigableMap, it is still backed by the same map as navigableMap
    NavigableMap<Integer, String> tail = navigableMap.tailMap(3, true);
    printMap(tail, "tail");
    // This will retrieves and removes the last element on the map
    println("tail.pollLastEntry() -> {}",tail.pollLastEntry());
    // Both will be affected since they're backed by the same map
    printMap(tail, "tail");
    printMap(navigableMap, "navigableMap");

  }

  private static void printMap(NavigableMap<Integer, String> navigableMap, String mapName) {
    print("{} = ", mapName);
    navigableMap.forEach((k, v) -> print("{}-{}  ", k, v));
    println();
  }

}
