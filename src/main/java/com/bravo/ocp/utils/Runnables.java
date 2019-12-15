package com.bravo.ocp.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Runnables {

    public static Runnable sayHello() {
        return sayMessage("Hello");
    }

    public static Runnable sayHello(String message) {
        return sayMessage("Hello " + message);
    }

    public static Runnable sayMessage(String message) {
        return () -> printlnWithThreadId((message));
    }

    public static Callable<String> sayAndReturnHello() {
        return () -> {
            String hello = "Hello from callable";
            printlnWithThreadId(hello);
            return hello;
        };
    }

    public static Runnable sayHelloMultipleTimes(Integer timesToSayHello) {
        return () -> IntStream.range(0, timesToSayHello).forEach(value -> printlnWithThreadId("Hello " + value));
    }

    public static Runnable waitRunnable(int timeToWaitInMillis) {
        return () -> {
            printlnWithThreadId("Waiting...");
            PrintUtils.sleep(timeToWaitInMillis);
            printlnWithThreadId(TimeUnit.MILLISECONDS.toSeconds(timeToWaitInMillis) + " seconds has been passed! ");
        };
    }

    public static void printlnWithThreadId(String message) {
        PrintUtils.println("Thread {} {}", Thread.currentThread().getId(), message);
    }


}
