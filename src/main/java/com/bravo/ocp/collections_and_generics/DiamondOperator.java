package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Esteban on 3/12/2019.
 */
public class DiamondOperator {

  public static void main(String[] args) {

    //List without generic type specification is like List<Object>
    List list = Arrays.asList(1, "2", 3.0, new Object());
    // or as follows
    //List list = new ArrayList();
    //List list = new ArrayList<>();
    //list.add(1);
    //list.add("2");
    //list.add(3.0);
    //list.add(new Object());
    println("1. List list = new ArrayList() with Objects : {}", list);

    List<String> stringList = Arrays.asList("1", "2", "3"); //  Arrays.asList creates a new ArrayList<> using diamond operator
    //Or as follows.
    //List<String> stringList = new ArrayList<>();
    //List<String> stringList = new ArrayList<String>();
    //stringList.add("1");
    //stringList.add("2");
    //stringList.add("3");
    println("2. List<String> list = new ArrayList<String>() with Strings : {}", stringList);

    // This is the same as the last example, but it uses diamond operator. new ArrayList<>() infers the type from the declaration List<String>
    List<String> stringListWithDiamond = new ArrayList<>();
    stringListWithDiamond.add("1");
    stringListWithDiamond.add("2");
    stringListWithDiamond.add("3");
//        stringListWithDiamond.add(new Integer(4)); // This wont compile since stringListWithDiamond expects only String objects
    println("3. List<String> list = new ArrayList<>() with Strings using diamond operator : {}", stringListWithDiamond);

    // List<?> objectsList means List<? extends Object> so any type in the list is valid
      // these are read only lists
    List<?> wildcardStringList = new ArrayList<String>();
    List<?> wildcardIntegerList = new ArrayList<Integer>();
    //Since we don't specify the type in new ArrayList(), the list can take any Object
    // Is the same as List<?> wildcardObjectList = new ArrayList<Object>();
    // or List<?> wildcardObjectList = new ArrayList<>();
    List<?> wildcardObjectList = new ArrayList();
    wildcardObjectList.addAll(list);
    println("4. List<?> wildcardObjectList = new ArrayList() with Objects without diamond operator : {}", wildcardObjectList);
    // but none of the following are valid options
    //List<?> wildcardInvalidList1 = new ArrayList<? extends Number>();
//        List<?> wildcardInvalidList2 = new ArrayList<?>();

    List<? extends Number> numbers = Arrays.asList(1, 3.5f, 3L, 4.0);
    //Or as follows using diamond operator
    /*List<? extends Number> numbers = new ArrayList<>();*/

    //the following lines wont compile
    //List<? extends Number> numbers = new ArrayList<?>();
    //List<? extends Number> numbers = new ArrayList<? extends Number>();

    println("5. List<? extends Number> numbers = new ArrayList<>() with Numbers : {}", numbers);
    numbers.forEach(n -> println("--- {} of class {}", n, n.getClass()));

    Map<String, List<? extends Number>> numberTypeNumbersMap = new HashMap<String, List<? extends Number>>();
    //Or using diamond operator
    // Map<String, List<? extends Number>> numberTypeNumbersMap = new HashMap<>();

    //Following are invalid options
    //Map<String, List<? extends Number>> numberTypeNumbersMap2 = new HashMap<String, List<>>();
    //Map<String, List<? extends Number>> numberTypeNumbersMap2 = new HashMap<String, List<?>>();
    //Map<String, List<? extends Number>> numberTypeNumbersMap2 = new HashMap<String, List>();
    //Map<String, List<? extends Number>> numberTypeNumbersMap2 = new HashMap<String, List<Integer>>();

    numberTypeNumbersMap.put("Integer", Arrays.asList(1, 2, 3));
    numberTypeNumbersMap.put("Float", Arrays.asList(1f, 2f, 3f));
    numberTypeNumbersMap.put("Double", Arrays.asList(1D, 2D, 3D));

    println("6. Map<String, List<? extends Number>> numberTypeNumbersMap = new HashMap<String, List<? extends Number>>(): {}",
        numberTypeNumbersMap);
    numberTypeNumbersMap.entrySet().forEach(entry -> println("--- key: {} values: {}", entry.getKey(), entry.getValue()));


    List<String> listStr = DiamondOperator.<String>getList();
    List<String> listStr2 = DiamondOperator.getList();
    List<?> listStr3 = DiamondOperator.getList();

  }


  public static <X> List<X> getList(){
    return new ArrayList<X>();
  }

}


