
package com.bravo.ocp.concurrency;

import java.util.concurrent.*;

import static com.bravo.ocp.concurrency.Utils.sayAndReturnHello;
import static com.bravo.ocp.concurrency.Utils.sayHello;

public class UsingNewSingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = null;
        //It is a good practice to use the Finally block of a try to close the ExecutorService
        try {
            // Executors factory methods to create ExecutorService instances
            // newSingleThreadExecutor() simplest way to create a thread.
            // Only one ne thread is crated.
            // Tasks are executed in sequence.
            executor = Executors.newSingleThreadExecutor();
            // we can execute a task passing a Runnable to the execute() in the ExecutorService instance
            executor.execute(sayHello());
            // or submit a task with submit()using a Callable lambda as argument. This returns a Future<T>
            Future<String> future = executor.submit(sayAndReturnHello());
            // Wait till the task is completed
            //            /*while (!future.isDone()) {
            //                System.out.println("waiting executor to ends.");
            //                Thread.sleep(0L);
            //            }*/
            // We prefer to call a get with timeout
            System.out.println(future.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.err.println("A timeout has occurred executing the task");
        } finally {
            // All executors should be shutdown
            ExecutorsUtils.shutdownExecutorAndReport(executor, 5L);
        }
    }


}
