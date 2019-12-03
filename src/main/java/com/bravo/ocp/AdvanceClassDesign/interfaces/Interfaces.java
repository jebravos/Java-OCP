package com.bravo.ocp.AdvanceClassDesign.interfaces;


import static com.bravo.ocp.utils.PrintUtils.println;

public class Interfaces {
    public static void main(String[] args) {
        Greeter g = new Greeter();
        g.sayHello();
        // Classes implementing an interface may or may not override a default method
        g.sayDefaultHello();
        //
        g.sayGoodBy();
        // We have public access to Interfaces attributes since they're always public final static
        println(MyInterface.GREETING);
    }
}


// Classes can implements ocp.interfaces
class Greeter implements IGreeter{

    // Classes should overrides all abstract ocp.interfaces methods
    @Override
    public void sayHello() {
        println("Hello from Greeter");
    }

    @Override
    public void sayGoodBy() {
        println("Good by folks!");
    }

    // Classes implementing an interface may or may not override a default method
    // Since Greeter does not overrides sayDefaultHello, it will have the default implementation
}

// Interfaces can extends other ocp.interfaces
interface IGreeter extends MyInterface{
    void sayGoodBy();
}


