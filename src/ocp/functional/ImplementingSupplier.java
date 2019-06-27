package ocp.functional;

import java.time.LocalDate;
import java.util.function.Supplier;

public class ImplementingSupplier {
    // Supplier is used to generate or supply values without taking any input
    private Supplier<LocalDate> dateSupplier = LocalDate::now;
    // It could be also:
    // Supplier<LocalDate> dateSupplier = () -> LocalDate.now();
    // or
    // Supplier<LocalDate> dateSupplier = () -> { return LocalDate.now(); };

    // Supplier using constructor reference
    private Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;

    public static void main(String[] args) {
        ImplementingSupplier is = new ImplementingSupplier();
        System.out.println(is.dateSupplier.get());
        System.out.println(is.stringBuilderSupplier.get().append("hola mundo"));
    }


}
