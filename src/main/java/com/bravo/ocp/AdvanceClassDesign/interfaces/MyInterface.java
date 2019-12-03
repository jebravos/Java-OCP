package com.bravo.ocp.AdvanceClassDesign.interfaces;

import static com.bravo.ocp.utils.PrintUtils.println;

//An interface is an abstract data type
public interface MyInterface {

    // Interfaces can contain attributes. These attributes are implicitly public final static (Constants),  so this
    // public final static String GREETING = "Hello from My Interface";
    // is going to be the same as:
    String GREETING = "Hello from My Interface";


    // All its methods are public abstract so this
    // public abstract String sayHello();
    // is the same as
    void sayHello();


    // Interfaces can also have default methods, these are implicitly public
    default void sayDefaultHello(){
        println(GREETING);
    }

}
