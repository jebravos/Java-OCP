
package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.Runnables.sayAndReturnHello;
import static com.bravo.ocp.utils.Runnables.sayHello;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UsingNewSingleThreadScheduledExecutor {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = null;
        try {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            // schedules a task to an instant in the future (2 seconds after)
            // In the next example, sayAndReturnHello() will be executed first since it is scheduled in a future before before the task sayHello() execution
            // Tasks are scheduled sequentially to be executed in the future
            // You can use a Runnable
            scheduledExecutorService.schedule(sayHello(), 4, TimeUnit.SECONDS);
            // Or a Callable
            scheduledExecutorService.schedule(sayAndReturnHello(), 2, TimeUnit.SECONDS);
        } finally {
            ExecutorsUtils.shutdownExecutorAndReport(scheduledExecutorService, 5L);
        }

    }



}
