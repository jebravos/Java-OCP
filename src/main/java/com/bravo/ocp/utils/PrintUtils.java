package com.bravo.ocp.utils;

import static com.bravo.ocp.utils.StringUtils.format;
import static com.bravo.ocp.utils.StringUtils.stringValueOrNull;

import java.util.function.Supplier;

public class PrintUtils {



    public static void print(Object o) {
        System.out.print(stringValueOrNull(o));
    }

    public static void print(String template, Object... args) {
        print(format(template, args));

    }

    public static void println() {
        println("");
    }

    public static void println(Supplier<?> supplier) {
        println(supplier.get());
    }

    public static void println(Object o) {
        println(stringValueOrNull(o));
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println(String template, Object... args) {
        println(format(template, args));
    }

    public static void err(Object o) {
        err(stringValueOrNull(o));
    }

    public static void err(String template, Object... args) {
        err(format(template, args));
    }

    public static void err(String message){
        System.err.println(message);
    }

    //TODO move this to another class
    public static void sleep(long timeToWaitInMillis) {
        try {
            Thread.sleep(timeToWaitInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error while sleeping", e.getCause());
        }
    }


    public static void main(String[] args) {
//        println("Hello {} ... {} ... {}", "world", "aze", "123");
//        println("Hello {} ... {} ... {}", "AZE");
//        println("Hello {} ... {} ... {}", null, null, "123");
//        Duration hourly = Duration.ofHours(1);
//        LocalTime now = LocalTime.now();
//        println("difference in minutes between {} and {} : {}", now, "and" , now.plus(hourly), ChronoUnit.MINUTES.between(now, now.plus(hourly)));

    }
}
