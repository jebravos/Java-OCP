package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Utils {

    static Runnable sayHello(){
        return sayHello("");
    }


    static Runnable sayHello(String message){
        return () -> System.out.println("Thread " + Thread.currentThread().getId() + " Hello " + message);
    }

    static Callable<String> sayAndReturnHello(){
        return () -> {
            String hello = "Hello from callable";
            System.out.println("Thread " + Thread.currentThread().getId() + " " + hello);
            return  hello;
        };
    }


    static Runnable sayHelloMultipleTimes(Integer timesToSayHello) {
        return () -> IntStream.range(0, timesToSayHello).forEach(value -> sayHello(" " + value).run());
//        return () -> IntStream.range(0, timesToSayHello).forEach(value -> System.out.println("Thread " + Thread.currentThread().getId() + " Hello " + value));
    }

    static Runnable waitRunnable(int timeToWaitInMillis) {
        return () -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getId() + " Waiting...");
                wait(timeToWaitInMillis);
                System.out.println("Thread " + Thread.currentThread().getId() + " " + TimeUnit.MILLISECONDS.toSeconds(timeToWaitInMillis) + " seconds has been passed! ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public static void wait(int timeToWaitInMillis) throws InterruptedException {
        Thread.sleep(timeToWaitInMillis);
    }


}
