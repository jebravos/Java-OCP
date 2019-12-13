package com.bravo.ocp.collections_and_generics.collections;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.HashMap;
import java.util.Map;

public class UsingMaps {


  public static void main(String[] args) {

    Map<Integer, String> map = new HashMap<>();
    // Puts the entries in the map
    map.put(1, "1");
    map.put(2, "2");

    // If the key does exists in the map, it will use the remapping function to merge the existent value with the given value
    map.merge(2, "2", String::concat);
    // If the key does not exists, the given value will be mapped to the given key, the remapping function is ignored
    map.merge(3, "3", String::concat);

    println(map);
  }

}
