package ocp.concurrency;

import ocp.utils.PrintUtils;

import java.util.*;
import java.util.concurrent.*;

import static ocp.utils.PrintUtils.print;
import static ocp.utils.PrintUtils.println;

public class UsingConcurrentCollections3 {

    public static void main(String[] args) {
        // Based on your knowledge of collections from Chapter 3, classes like ConcurrentHashMap ,
        // ConcurrentLinkedQueue , and ConcurrentLinkedDeque should be quite easy for you to learn
        usingSimpleConcurrentCollections();
        understandingBlockingQueues();
        understandingBlockingDequeues();
        understandingSkipListCollections();
        understandingCopyOnWriteCollections();
    }

    private static void usingSimpleConcurrentCollections() {
        PrintUtils.println("--------Using simple Concurrent Collections --------");
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        PrintUtils.println(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        PrintUtils.println(queue.peek());
        PrintUtils.println(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        PrintUtils.println(deque.peek());
        PrintUtils.println(deque.pop());
        PrintUtils.println("-----------------------------------------------------");

    }

    private static void understandingBlockingQueues() {
        PrintUtils.println("-------- Understanding Blocking Queues--------");
        try {

            // A LinkedBlockingQueue maintains a linked list between the elements.
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

            // It's like a regular queue
            blockingQueue.offer(39);
            // except that it includes methods that will wait a specific amount of time to complete an operation
            // offer(E, e, long timeout, TimeUnit unit) adds item to the queue waiting the specified time,
            // returning false if time elapses before space is available.
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);

            PrintUtils.println(blockingQueue);
            PrintUtils.println(blockingQueue.poll());
            // poll(long timeout, TimeUnit unit) Retrieves and removes an item from the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            PrintUtils.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));

            PrintUtils.println(blockingQueue);


        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        PrintUtils.println("-----------------------------------------------------");
    }

    private static void understandingBlockingDequeues() {
        PrintUtils.println("-------- Understanding Blocking Dequeues--------");
        // A LinkedBlockingDeque maintains a linked list between the elements.
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();


        PrintUtils.println(blockingDeque);
        try {
            // Since a BlockingDequeu Inherits all the methods from Queue, we are able to use offer(E e) method
            blockingDeque.offer(1);
            blockingDeque.offer(2);
            blockingDeque.offer(3);
            // offerFirst(E, e, long timeout, TimeUnit unit) adds item to the front of the queue waiting the specified time,
            blockingDeque.offerFirst(0, 5L, TimeUnit.SECONDS);
            PrintUtils.println(blockingDeque);
            // offerLast(E, e, long timeout, TimeUnit unit) adds item to the tail of the queue waiting the specified time,
            blockingDeque.offerLast(4, 5L, TimeUnit.SECONDS);
            PrintUtils.println(blockingDeque);
            // pollFirst(long timeout, TimeUnit unit) Retrieves and removes from the Front of the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            PrintUtils.println(blockingDeque.pollFirst(5L, TimeUnit.SECONDS));
            // pollFirst(long timeout, TimeUnit unit) Retrieves and removes from the tail of the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            PrintUtils.println(blockingDeque.pollLast(5L, TimeUnit.SECONDS));
            PrintUtils.println(blockingDeque);
            PrintUtils.println("-----------------------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void understandingSkipListCollections() {
        PrintUtils.println("-------- Understanding Skip List Collections --------");
        // Think "sorted" concurrent collections
        // Like other queue examples it's recommended that you assign these objects to interface references such as SortedMap or NavigableSet
        PrintUtils.println("-----------------------------------------------------");

    }

    private static void understandingCopyOnWriteCollections() {
        PrintUtils.println("-------- Understanding copy on write Collections --------");
        // CopyOnWriteArrayList
        // CopyOnWriteArraySet
        // These classes copy all of their elements to a new underlying structure anytime an element us aded, modified or removed from the collection.
        // Although the date is copied to a new underlying structure, pur reference to the object not change.
        // This is particularly useful in multi-threaded environments that need to iterate the collection.
        // Any iterator established prior to a modification will not see the changes, but instead it will iterate over the original elements prior to the modification.

        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for (Integer i: list) {
            print("{} ", i);
            list.add(9);
        }

        // Despite adding elements to the array while iterating over it, only those elements in the collection at the time for() loop was created were accessed.
        // Alternatively, if <e had used a regular ArrayList object; a ConcurrentModificationException would have been thrown at runtime.
        PrintUtils.println();
        PrintUtils.println(String.valueOf(list.size()));


        PrintUtils.println("-----------------------------------------------------");

    }


}