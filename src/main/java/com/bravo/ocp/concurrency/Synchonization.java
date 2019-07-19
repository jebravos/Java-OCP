package com.bravo.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// Race Condition: The unexpected result of two tasks executing at the same time.
public class Synchonization {

    public static void main(String[] args) throws InterruptedException {
        // Not all increments assured nor the order
        testNonSynchronizedSheepManager();

        // Data consistency assured but not the order
//        testAtomicSheepManager();

        // Data consistency and order are assured
//        testSynchronizedBlockOnNonSynchronizedSheepManager();
    }

    private static void testNonSynchronizedSheepManager() throws InterruptedException {
        countSheeps(new NotSynchronizedSheepManager());

    }

    private static void testAtomicSheepManager() throws InterruptedException {
        countSheeps(new AtomicSheepManager());
    }

    private static void testSynchronizedBlockOnNonSynchronizedSheepManager() throws InterruptedException {
        countSheeps(new SynchronizedSheepManager());
    }

    private static void countSheeps(SheepManager sheepManager) throws InterruptedException {
        ExecutorService executorService = null;
        try {
            // A big thread pool of 20 thread to assure that all tasks will run concurrently
            executorService = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 10; i++)
                executorService.submit(sheepManager::incrementAndReport);

        } finally {
            ExecutorsUtils.shutdownExecutorAndReport(executorService, 10);
        }
    }

}

abstract class SheepManager {
    abstract void incrementAndReport();
}

class NotSynchronizedSheepManager extends SheepManager {

    // Multiple Threads will share this variable
    // Any thread trying to access the sheepCount variable while an atomic operation is in rocess will hav to sleep until the atomic operation on the variable is complete.
    private int sheepCount = 0;

    @Override
        //Not synchronized method
    void incrementAndReport() {
        // Increment operator (++) is not thread safe. This could create a race condition
        // Two threads calling ++sheepCount at the same time result in one of the increment operations actually being lost.
        System.out.println((++sheepCount) + " Sheeps");
    }

}

class AtomicSheepManager extends SheepManager {
    // Multiple Threads will share this variable
    // Java atomic classes: Atomic is the property of an operation to be carried out as a single unit of execution without an interference vy another thread.
    // Using atomic classes  we ensure that the data is consistent between threads and that no values are lost due to a concurrent modification
    private AtomicInteger sheepCount = new AtomicInteger(0);

    @Override
        //Not synchronized method
    void incrementAndReport() {
        // incrementAndGet() is the thread-safe atomic version of increment operator.
        System.out.println((sheepCount.incrementAndGet()) + " Sheeps");
    }

}

class SynchronizedSheepManager extends SheepManager {
    // Multiple Threads will share this variable
    private AtomicInteger sheepCount = new AtomicInteger(0);

    @Override
    // we could synchronized the method with void incrementAndReport() { to synchronize on the object itself
    // The result will would be the same.
    void incrementAndReport() {
        // Any Thread wanting to access to the synchronized block will  have to sleep till any other thread is executing it
        // >e could have synchronized on any object so long it was the same object
        synchronized (this) {
            System.out.println((sheepCount.incrementAndGet()) + " Sheeps");
        }
    }

}

