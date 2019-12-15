
package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.Runnables.sayAndReturnHello;

import com.bravo.ocp.utils.ExecutorsUtils;
import com.bravo.ocp.utils.Runnables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsingNewSingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = null;
        //It is a good practice to use the Finally block of a try to close the ExecutorService
        try {
            // Executors factory methods to create ExecutorService instances
            // newSingleThreadExecutor() simplest way to create a thread.
            // Only one thread is created.
            // Tasks are executed in sequence.
            executor = Executors.newSingleThreadExecutor();
            // we can execute a task passing a Runnable to the execute() in the ExecutorService instance
            executor.execute(Runnables.sayHello());
            // or submit a task with submit()using a Callable lambda as argument. This returns a Future<T>
            Future<String> future = executor.submit(sayAndReturnHello());
            // Wait till the task is completed
            //            /*while (!future.isDone()) {
            //                System.out.println("waiting executor to ends.");
            //                Thread.sleep(0L);
            //            }*/
            // We prefer to call a get with timeout
            println(future.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            println("A timeout has occurred executing the task");
        } finally {
            // All executors should be shutdown
            ExecutorsUtils.shutdownExecutorAndReport(executor, 5L);
        }
    }


}
