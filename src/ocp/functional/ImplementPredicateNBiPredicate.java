package ocp.functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ImplementPredicateNBiPredicate {

    private Predicate<String> isEmptyPredicate = String::isEmpty;
    private BiPredicate<String, String> startsWithBiPredicate = String::startsWith;

    public static void main(String[] args) {
        ImplementPredicateNBiPredicate pnbp = new ImplementPredicateNBiPredicate();

        String hello = "Hello world";
        System.out.println(" " + " is empty " + pnbp.isEmptyPredicate.test(""));
        System.out.println(hello + " is empty " + pnbp.isEmptyPredicate.test(hello));
        System.out.println(hello + " starts with hello " + pnbp.startsWithBiPredicate.test(hello, "hello"));
        System.out.println(hello + " starts with Hello " + pnbp.startsWithBiPredicate.test(hello, "Hello"));

    }

}
