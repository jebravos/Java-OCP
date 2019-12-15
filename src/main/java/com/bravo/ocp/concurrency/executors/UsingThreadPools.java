package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.Runnables.sayHello;
import static com.bravo.ocp.utils.Runnables.waitRunnable;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingThreadPools {

    public static void main(String[] args) throws InterruptedException {

        // newCachedThreadPool() creates a pool that creates new Threads as needed; but will reuse previously constructed Threads when they are available
//        ExecutorService executorService = Executors.newCachedThreadPool();
        // newFixedThreadPool(int nThreads) Creates a thread poll that reuses a fixed number of threads operating off a shared unbounded queue
         ExecutorService executorService = Executors.newFixedThreadPool(2);

        try{
            executorService.submit(waitRunnable(5000));
            executorService.submit(sayHello());
            executorService.submit(waitRunnable(2000));
        }finally {
            ExecutorsUtils.shutdownExecutorAndReport(executorService, 5L);
        }
    }

}
