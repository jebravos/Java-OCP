package com.bravo.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.bravo.ocp.utils.PrintUtils.println;

class ExecutorsUtils {


    static void shutdownNowExecutorAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if(executorService != null){
            executorService.shutdownNow();
            awaitExecutorTerminationAndReport(executorService, timeoutInSeconds);
        }
    }

    private static void awaitExecutorTerminationAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if (executorService.awaitTermination(timeoutInSeconds, TimeUnit.SECONDS)) {
            println("All tasks have been executed and executor has been successfully shut down!!!");
        }
    }


    static void shutdownExecutorAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if(executorService != null){
            executorService.shutdown();
            awaitExecutorTerminationAndReport(executorService, timeoutInSeconds);
        }
    }

}
