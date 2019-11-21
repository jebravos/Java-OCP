package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

// Functional ocp.interfaces are those who contains a single abstract method
// It can be marked with the annotation @FunctionalInterface as a good practice but it's not mandatory. If you use the annotation and the interface has more than one abstract method it won't compile.
// They're used as basis for lambda expressions in ocp.functional programming
@FunctionalInterface
public interface MyFunctionalInterface {

    // As normal ocp.interfaces, FI may have attributes which will be public final static implicitly. (CONSTANTS)
    String DEFAULT_GREETING = "Default greeting";

    void sayHello();

    // Functional ocp.interfaces may have or not default methods
    default void sayDefaultGreeting(){
        println(DEFAULT_GREETING);
    }
}
