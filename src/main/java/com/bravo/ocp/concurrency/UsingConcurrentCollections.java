package com.bravo.ocp.concurrency;

import com.bravo.ocp.utils.ExecutorsUtils;
import com.bravo.ocp.utils.Runnables;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingConcurrentCollections {


    public static void main(String[] args) throws InterruptedException {
//        testingNonThreadSafeZooManager();
//        testingSynchronizedZooManager();
        testingConcurrentCollectionZooManager();
    }

    private static void testingNonThreadSafeZooManager() throws InterruptedException {

        feedAnimals(new NonSynchronizedZooManager());
    }

    private static void testingSynchronizedZooManager() throws InterruptedException {

        feedAnimals(new SynchronizedZooManager());
    }

    private static void testingConcurrentCollectionZooManager() throws InterruptedException {

        feedAnimals(new ConcurrentCollectionZooManager());
    }

    private static void feedAnimals(ZooManager zooManager) throws InterruptedException {
        ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(3);
            executorService.submit(() -> zooManager.put("Lion", "Meat"));
            executorService.submit(() -> zooManager.put("Bear", "Fish"));
            executorService.submit(() -> zooManager.put("Chicken", "Corn"));
            executorService.submit(() -> zooManager.put("Chicken", "CornModified"));
            executorService.submit(Runnables.sayMessage("Lion eats " + zooManager.get("Lion").toString()));
            executorService.submit(Runnables.sayMessage("Bear eats " + zooManager.get("Bear").toString()));
            executorService.submit(Runnables.sayMessage("Chicken eats " + zooManager.get("Chicken").toString()));

        } finally {
            ExecutorsUtils.shutdownExecutorAndReport(executorService, 5);
        }
    }
}


class NonSynchronizedZooManager extends ZooManager {


    private Map<String, Object> foodMap = new HashMap<>();

    @Override
    public void put(String key, String value) {
        foodMap.put(key, value);
    }

    @Override
    public Object get(String key) {
        return foodMap.get(key) != null ? foodMap.get(key) : "Not found!";
    }
}

class SynchronizedZooManager extends ZooManager {


    private Map<String, Object> foodMap = new HashMap<>();

    @Override
    public synchronized void put(String key, String value) {
        foodMap.put(key, value);
    }

    @Override
    public synchronized Object get(String key) {
        return foodMap.get(key) != null ? foodMap.get(key) : "Not found!";
    }
}

class ConcurrentCollectionZooManager extends ZooManager {

    // Using concurrent collections prevents us from introducing mistakes in our own custom implementation,
    // such as if we forgot to synchronize one of the accessors methods.
    // Concurrent collections often include performance enhancements that avoid unnecessary synchronization.

    // The use of concurrent collections is to solve common memory consistency errors.
    // A memory consistency error occurrs when two threads have inconsistent of views wat should be the same data.
    private Map<String, Object> foodMap = new ConcurrentHashMap<>();

    @Override
    public synchronized void put(String key, String value) {
        foodMap.put(key, value);
    }

    @Override
    public synchronized Object get(String key) {
        return foodMap.get(key) != null ? foodMap.get(key) : "Not found!";
    }
}


abstract class ZooManager {

    public abstract void put(String key, String value);

    public abstract Object get(String key);

}