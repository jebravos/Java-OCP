package functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ImplementingFunctionNBiFunction {

    // A function is responsible for turning one parameter into a value of a potentially different type and returning it.
    Function<String, Integer> lengthFunction = String::length;
    BiFunction<String, String, String> concatBiFunction = String::concat;

    public static void main(String[] args) {
        ImplementingFunctionNBiFunction ifnbf = new ImplementingFunctionNBiFunction();
        String hello = "Hello World";
        String friend = "friend";
        System.out.println("length of " + hello + ": " + ifnbf.lengthFunction.apply(hello));
        System.out.println("Concatenating " + hello + " and " + friend + ": " + ifnbf.concatBiFunction.apply(hello, friend));
    }
}
