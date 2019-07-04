package ocp.concurrency;

import ocp.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static ocp.concurrency.ExecutorsUtils.shutdownExecutorAndReport;
import static ocp.utils.PrintUtils.println;

public class UsingNewSingleThreadExecutor3 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = null;

        try {
            executor = Executors.newSingleThreadExecutor();
            Collection<Callable<Boolean>> tasks = new ArrayList<>();
            tasks.add(sayHello());
            tasks.add(sayHelloMultipleTimes(10));

            // invokeAll executes the given tasks synchronously returning the results of all tasks as a Collection of Future objects
            // in the same order they were in the original collection
            List<Future<Boolean>> futures = executor.invokeAll(tasks);
            printFutureResultWhenReady(futures);

        } finally {
            // All executors should be shutdown
            shutdownExecutorAndReport(executor,10L);
        }
    }

    private static Callable<Boolean> sayHelloMultipleTimes(Integer timesToSayHello) {

        return () -> {
            Utils.sayHelloMultipleTimes(timesToSayHello).run();
            return Boolean.TRUE;
        };
    }

    private static Callable<Boolean> sayHello() {

        return () -> {
            Utils.sayHello().run();
            return Boolean.TRUE;
        };
    }

    private static void printFutureResultWhenReady(List<Future<Boolean>> futures) {

        // We iterate over the Future list in order to get their result
        //TODO review this implementation
        // Search for a better way to wait to a list of futures to complete
        for (Future f : futures) {
            try {
                // get() will block the execution till it receives a response
                // since get waits endlessly if is not yet available we prefer to use a get(long timeout, TimeUnit unit)
                PrintUtils.println(f.get(1, TimeUnit.SECONDS));
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }
        }
    }
}
