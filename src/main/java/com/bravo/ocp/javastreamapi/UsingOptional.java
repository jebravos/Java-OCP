package com.bravo.ocp.javastreamapi;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.Optional;

public class UsingOptional {

  public static void main(String[] args) {

    Optional<String> anOptional = Optional.empty();
    println("empty optional: {}", anOptional);

    println("non empty optional: {}", anOptional.of("Non empty"));
    println("empty optional since last line didn't modify anOptional instance: {}", anOptional);

    println("anOptional content: {}", anOptional.orElseGet(() -> "Empty..."));
    println("non empty Optional content: {}", Optional.of("hello world").orElse(""));
    println("Optional when null content using orElse: {}", Optional.ofNullable(null).orElse("value orElse"));
    println("Optional when null content using orElse returning null: {}", Optional.ofNullable(null).orElse(null));


  }

}
