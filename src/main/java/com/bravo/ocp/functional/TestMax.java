package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.print;
import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.Arrays;
import java.util.List;

public class TestMax {

  public static void main(String[] args) {

    println(" max between 1 and 2 : {}", myMax(1, 2));
    println(" max between 2 and 1 : {}", myMax(2, 1));

    List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
    println(ls.stream().max(TestMax::myMax).get()); //2
  }


  public static int myMax(int i, int j){
    print("i: {} - j: {}     ",i,j);
    println("max:  {}",Integer.max(i,j));
    return Integer.max(i,j);
  }

}
