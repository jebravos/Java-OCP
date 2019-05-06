package functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ImplementComsumerNBiconsumer {

    // You use consumer when you want to do something with a parameter but no return is needed.
    // BiConsumer takes 2 parameters.
    Consumer<String> stringPrinter = System.out::println;
    // It could be also:
    // Consumer<String> stringPrinter = s -> System.out.println(s);
    Map<String, Integer> personToAgeMap = new HashMap<>();
    BiConsumer<String, Integer> putInpersonToAgeMapConsumer = personToAgeMap::put;

    public static void main(String[] args) {
        ImplementComsumerNBiconsumer cbc = new ImplementComsumerNBiconsumer();
        cbc.stringPrinter.accept("This was printed using Consumer");

        cbc.putInpersonToAgeMapConsumer.accept("Maria", 23);
        cbc.putInpersonToAgeMapConsumer.accept("Esteban", 31);

        System.out.println(cbc.personToAgeMap);
    }

}
