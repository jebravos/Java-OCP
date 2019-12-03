package com.bravo.ocp.concurrency;

import com.bravo.ocp.utils.PrintUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static com.bravo.ocp.utils.PrintUtils.println;

class Utils {

    static Runnable sayHello() {
        return sayMessage("Hello");
    }

    static Runnable sayHello(String message) {
        return sayMessage("Hello " + message);
    }

    static Runnable sayMessage(String message) {
        return () -> printlnWithThreadId((message));
    }

    static Callable<String> sayAndReturnHello() {
        return () -> {
            String hello = "Hello from callable";
            printlnWithThreadId(hello);
            return hello;
        };
    }

    static Runnable sayHelloMultipleTimes(Integer timesToSayHello) {
        return () -> IntStream.range(0, timesToSayHello).forEach(value -> printlnWithThreadId("Hello " + value));
    }

    static Runnable waitRunnable(int timeToWaitInMillis) {
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
