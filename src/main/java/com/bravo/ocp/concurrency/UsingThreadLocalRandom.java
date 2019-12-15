package com.bravo.ocp.concurrency;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.concurrent.ThreadLocalRandom;

public class UsingThreadLocalRandom {


  public static void main(String[] args) {

    println("random int {}", ThreadLocalRandom.current().nextInt(100));
    println("random int {}", ThreadLocalRandom.current().nextInt(50,100));

    println("random boolean {}", ThreadLocalRandom.current().nextBoolean());
    println("random Long {}", ThreadLocalRandom.current().nextLong(0, 3));

  }

}
