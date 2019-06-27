package ocp.concurrency;

import ocp.utils.CommonUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static ocp.utils.CommonUtils.printLn;

class Utils {

    static Runnable sayHello(){
        return sayMessage("Hello");
    }


    static Runnable sayHello(String message){
        return sayMessage("Hello " + message);
    }

    static Runnable sayMessage(String message){
        return () -> printLnWithThreadId((message));
    }

    static Callable<String> sayAndReturnHello(){
        return () -> {
            String hello = "Hello from callable";
            printLnWithThreadId(hello);
            return  hello;
        };
    }


    static Runnable sayHelloMultipleTimes(Integer timesToSayHello) {
        return () -> IntStream.range(0, timesToSayHello).forEach(value -> printLnWithThreadId("Hello " + value));
    }

    static Runnable waitRunnable(int timeToWaitInMillis) {
        return () -> {
            try {
                printLnWithThreadId("Waiting...");
                CommonUtils.wait(timeToWaitInMillis);
                printLnWithThreadId(TimeUnit.MILLISECONDS.toSeconds(timeToWaitInMillis) + " seconds has been passed! ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private static void printLnWithThreadId(String message){
        printLn("Thread {} {}",Thread.currentThread().getId(), message);
    }


}
