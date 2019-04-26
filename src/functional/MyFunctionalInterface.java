package functional;

// Functional interfaces are thos who contains a single abstract method
// It can be marked with the annotation @FunctionalInterface as a good practice but it's not mandatory. If you use the annotation and the interface has more than one abstract method it won't compile.
// They're used as basis for lambda expressions in functional programming
@FunctionalInterface
public interface MyFunctionalInterface {

    // As normal interfaces, FI may have attributes which will be public final static implicitly. (CONSTANTS)
    String DEFAULT_GREETING = "Default greeting";

    void sayHello();

    // Functional interfaces may have or not default methods
    default void sayDefaultGreting(){
        System.out.println(DEFAULT_GREETING);
    }
}
