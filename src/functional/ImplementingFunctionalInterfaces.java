package functional;

public class ImplementingFunctionalInterfaces {


    public static void main(String[] args) {
        ImplementingFunctionalInterfaces  o = new ImplementingFunctionalInterfaces();
        o.withLamdas("Esteban");
    }

    public void withLamdas(String string){
        sayHello(()-> System.out.println("Hello from lambda!!! " + string));
    }

    public void sayHello(MyFunctionalInterface greeter){
        greeter.sayHello();
    }
}

// Interfaces can also extend functional interfaces.
// These interfaces can also be functional if they don't define more abstract methods.
@FunctionalInterface
interface MyFunctionalGreeter extends MyFunctionalInterface{
}

// This interface is not  afunctional interface since it has two abstract methos. The one defined in MyFunctionalInterface and sayGoodBy
interface MyNonFunctionalGreeter extends MyFunctionalInterface{
    void sayGoodBy(String name);
}

