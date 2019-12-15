package com.bravo.ocp.AdvanceClassDesign.inner_classes;

import static com.bravo.ocp.utils.PrintUtils.println;

public class InnerClassVsNestedStaticClass {
    public static void main(String[] args) {
        // Static nested classes does not need an outer instance to be created
        A.B b = new A.B();
        A.B b2 = new A.B();

        // Classes defined inside an interface are implicitly static.
        // So their creation does not require an outer class instance.
        IA.IB ib = new IA.IB();

        // For inner classes instantiation an instance of the outer class is required
        A.C c = new A().new C();
        //  Or
        A a = new A();
        A.C c1 = a.new C();

        // Accessing inner classes members
        b.i = 99;
        b2.j = 1;
        A.B.j = 2;

        println("b.i = {}", b.i);
        println("b2.i = {}", b2.i);
        println("static member j in A.B = {}", A.B.j);
    }
}


class A {
    // A static nested class. It could be used in other places without an outer instance
    // A static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.
    static class B{
        // A static nested class can contain non static members
        int i;
        // and can also contain static members
        static int j;

        static void voidMethod(){
            println("");
        }

    }

    // Inner class: It means a NON STATIC class defined inside a class.
    // An outer instance is needed in order to use it.
    class C{
        // Inner classes can have static members only if they're also made final
        final static int i = 0;
        // the following doesn't work
        // static int i;

        // Inner classes cannot have static declarations
        // static void doesNotWork(){}

    }
}

interface IA {
    // Inner classes or interfaces defined inside an interface are always static
    class IB {
    }

    interface II{
    }
}

// classes/interfaces defined inside an interface can be used like
class MyIB implements IA.II{
}
