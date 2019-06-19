
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static concurrency.ExecutorsUtils.shutdownExecutorAndReport;
import static concurrency.Utils.sayAndReturnHello;
import static concurrency.Utils.sayHello;

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
            shutdownExecutorAndReport(scheduledExecutorService, 5L);
        }

    }



}
