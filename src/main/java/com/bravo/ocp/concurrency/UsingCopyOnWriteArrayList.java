package com.bravo.ocp.concurrency;

import com.bravo.ocp.utils.PrintUtils;

import com.bravo.ocp.utils.Runnables;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Esteban on 3/12/2019.
 */
public class UsingCopyOnWriteArrayList {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<>();
        threadSafeList.add("a");
        threadSafeList.add("b");
        threadSafeList.add("c");
        threadSafeList.add("d");
        threadSafeList.add("e");
        threadSafeList.add("f");
        threadSafeList.add("g");

        // Cyclic barrier will wait until 2 threads call await on it in order to execute the Runnable task given as parameter
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            PrintUtils.println("--After threads execution--");
            threadSafeList.forEach(Runnables::printlnWithThreadId);
            PrintUtils.println("-------------------------");
        });

        // A thread to remove elements & and g
        new Thread(() -> {
            threadSafeList.stream()
                    .filter(s -> "a".equals(s) || "g".equals(s))
                    // In CopyOnWriteArrayList all mutative operations are ConcurrentModificationException safe
                    .forEach(threadSafeList::remove);

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        ).start();

        // A thread that prints the list content
        new Thread(new Runnable() {
            @Override
            public void run() {
                // List content modifications wont be reflected until the end of the execution
                threadSafeList.forEach(Runnables::printlnWithThreadId);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
