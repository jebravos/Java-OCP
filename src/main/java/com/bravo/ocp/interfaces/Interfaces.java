package com.bravo.ocp.interfaces;


public class Interfaces {
    public static void main(String[] args) {
        Greeter g = new Greeter();
        g.sayHello();
        // Classes implementing an interface may or may not override a default method
        g.sayDefaultHello();
        //
        g.sayGoodBy();
        // We have public access to Interfaces attributes since they're always public final static
        System.out.println(MyInterface.GREETING);
    }
}


// Classes can implements ocp.interfaces
class Greeter implements IGreeter{

    // Classes should overrides all abstract ocp.interfaces methods
    @Override
    public void sayHello() {
        System.out.println("Hello from Greeter");
    }

    @Override
    public void sayGoodBy() {
        System.out.println("Good by folks!");
    }

    // Classes implementing an interface may or may not override a default method
    // Since Greeter does not overrides sayDefaultHello, it will have de default implementation
}


// Interfaces can extends other ocp.interfaces
interface IGreeter extends MyInterface{
    void sayGoodBy();
}


