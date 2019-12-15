package com.bravo.ocp.concurrency.executors;

import com.bravo.ocp.utils.ExecutorsUtils;
import com.bravo.ocp.utils.PrintUtils;
import com.bravo.ocp.utils.Runnables;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class UsingNewSingleThreadScheduledExecutor2 {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        try {
            // This schedules a task to be executed with 0 delay and creates a new task each 2 seconds, even the last task created haven't been executed or finished yet
            // This will run indefinitely!!!
            final ScheduledFuture<?> future = executorService.scheduleAtFixedRate(Runnables.sayHello(), 0, 2, TimeUnit.SECONDS);
            // scheduleWithFixedDelay() creates new tasks after a certain delay once the last task has been executed and finished.
//            executorService.scheduleWithFixedDelay(sayHello(), 0, 2, TimeUnit.SECONDS);
        } finally {
            // We force the executor to shutdown after 10 seconds since scheduleAtFixedRate() continue to create tasks indefinitely
            PrintUtils.sleep(5000);
            ExecutorsUtils.shutdownNowExecutorAndReport(executorService, 5L);
        }
    }
}
