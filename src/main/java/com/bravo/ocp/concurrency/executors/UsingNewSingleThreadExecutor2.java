package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.Runnables.sayAndReturnHello;
import static com.bravo.ocp.utils.Runnables.sayHelloMultipleTimes;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsingNewSingleThreadExecutor2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = null;
        try {
            // Only one ne thread is crated.
            // Tasks are executed in sequence.
            executor = Executors.newSingleThreadExecutor();
            // We can use executors passing a Runnable as argument
            executor.execute(sayHelloMultipleTimes(10)
            );
            // Or we can use executors passing a Callable as argument
            //When we use Callable version, executor will return a Future object representing the task
            Future<String> future = executor.submit(sayAndReturnHello());
            waitForMessageAndPrintIt(future);

        } finally {
            // All executors should be shutdown
            ExecutorsUtils.shutdownExecutorAndReport(executor, 5L);
        }
    }

    private static void waitForMessageAndPrintIt(Future<String> future) throws InterruptedException, ExecutionException, TimeoutException {
        // Instead of using a while loop to see if the Task has been executed and finished
        //       /* while(!future.isDone()){
        //            Thread.sleep(10);
        //        } */
        // we use the get() method, which will waits (get blocks the execution till it has a response) till the task is executed and the value is returned.
        // An exception is thrown if the timeout is exceeded
        println(future.get(10, TimeUnit.SECONDS));
    }

}
