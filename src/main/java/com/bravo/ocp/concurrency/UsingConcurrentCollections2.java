package com.bravo.ocp.concurrency;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsingConcurrentCollections2 {
    public static void main(String[] args) {
//        throwingAConcurrentModificationException();
        testLoopingAndRemoviengTheElementsOnConcurrentMap();
    }


    // The snippet will throw a ConcurrentModificationException since the iterator key set is not properly updated after the first element is removed
    private static void throwingAConcurrentModificationException() {
        Map<String, Object> foodData = new HashMap<>();
        loopOverAMapAndTryToRemoveTheElements(foodData);


    }

    // Using a ConcurrentMap instead prevent the code from throwing an exception at runtime.
    // Although we don't usually modify a loop variable this example highlights thr fact thath the ConcurrentHashMap is ordering Read/Write access such as all the class data is consistent.
    // In this code snippet, the iterator created by keySet() is updated as soon an object is removed from the Map
    private static void testLoopingAndRemoviengTheElementsOnConcurrentMap() {
        Map<String, Object> foodData = new ConcurrentHashMap<>();
        loopOverAMapAndTryToRemoveTheElements(foodData);


    }

    private static void loopOverAMapAndTryToRemoveTheElements(Map<String, Object> foodData) {
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);

        try {
            for (String key : foodData.keySet()) {
                foodData.remove(key);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Modifying a non concurrent collection will result in a " + e.getClass() + " be thrown...");
            e.printStackTrace();
        }

        System.out.println(foodData.keySet());
    }
}
