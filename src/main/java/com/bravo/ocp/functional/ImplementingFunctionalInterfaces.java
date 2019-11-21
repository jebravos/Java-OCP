package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

public class ImplementingFunctionalInterfaces {


    public static void main(String[] args) {
        ImplementingFunctionalInterfaces  o = new ImplementingFunctionalInterfaces();
        o.withLamdas("Esteban");
    }

    private void withLamdas(String string){
        sayHello(()-> println("Hello from lambda!!! " + string));
    }

    public void sayHello(MyFunctionalInterface greeter){
        greeter.sayHello();
    }
}

// Interfaces can also extend ocp.functional ocp.interfaces.
// These ocp.interfaces can also be ocp.functional if they don't define more abstract methods.
@FunctionalInterface
interface MyFunctionalGreeter extends MyFunctionalInterface{
}

// This interface is not a functional interface since it has two abstract methods. The one defined in MyFunctionalInterface and sayGoodBy
interface MyNonFunctionalGreeter extends MyFunctionalInterface{
    void sayGoodBy(String name);
}

