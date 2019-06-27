package ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ocp.concurrency.ExecutorsUtils.shutdownExecutorAndReport;
import static ocp.concurrency.Utils.sayHello;
import static ocp.concurrency.Utils.waitRunnable;

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
            shutdownExecutorAndReport(executorService, 5L);
        }
    }

}
