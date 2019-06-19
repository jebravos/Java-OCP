package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class ExecutorsUtils {


    static void shutdownNowExecutorAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if(executorService != null){
            executorService.shutdownNow();
            awaitExecutorTerminationAndReport(executorService, timeoutInSeconds);
        }
    }

    private static void awaitExecutorTerminationAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if (executorService.awaitTermination(timeoutInSeconds, TimeUnit.SECONDS)) {
            System.out.println("All tasks have been executed and executor has been successfully shut down!!!");
        }
    }


    static void shutdownExecutorAndReport(ExecutorService executorService, long timeoutInSeconds) throws InterruptedException {
        if(executorService != null){
            executorService.shutdown();
            awaitExecutorTerminationAndReport(executorService, timeoutInSeconds);
        }
    }

//    static void shutdownExecutorAndReport(ExecutorService executor) {
//        if (executor != null) {
//            executor.shutdown();
//            while (!executor.isTerminated()) {
//                System.out.println("shutting down...");
//            }
//            System.out.println("All tasks have been executed and executor has been successfully shut down!!!");
//        }
//    }


}
