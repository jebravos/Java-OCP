package ocp.concurrency;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

import static ocp.utils.CommonUtils.printLn;

public class UsingConcurrentCollections3 {

    public static void main(String[] args) {
        // Based on your knowledge of collections from Chapter 3, classes like ConcurrentHashMap ,
        // ConcurrentLinkedQueue , and ConcurrentLinkedDeque should be quite easy for you to learn
        usingSimpleConcurrentCollections();
        understandingBlockingQueues();
        understandingBlockingDequeues();
    }

    private static void usingSimpleConcurrentCollections() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        printLn(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        printLn(queue.peek());
        printLn(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        printLn(deque.peek());
        printLn(deque.pop());
        printLn("-----------------------------------------------------");

    }

    private static void understandingBlockingQueues() {
        try {

            // A LinkedBlockingQueue maintains a linked list between the elements.
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

            // It's like a regular queue
            blockingQueue.offer(39);
            // except that it includes methods that will wait a specific amount of time to complete an operation
            // offer(E, e, long timeout, TimeUnit unit) adds item to the queue waiting the specified time,
            // returning false if time elapses before space is available.
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);

            printLn(blockingQueue);
            printLn(blockingQueue.poll());
            // poll(long timeout, TimeUnit unit) Retrieves and removes an item from the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            printLn(blockingQueue.poll(10, TimeUnit.MILLISECONDS));

            printLn(blockingQueue);


        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        printLn("-----------------------------------------------------");
    }

    private static void understandingBlockingDequeues() {
        // A LinkedBlockingDeque maintains a linked list between the elements.
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();


        printLn(blockingDeque);
        try {
            // Since a BlockingDequeu Inherits all the methods from Queue, we are able to use offer(E e) method
            blockingDeque.offer(1);
            blockingDeque.offer(2);
            blockingDeque.offer(3);
            // offerFirst(E, e, long timeout, TimeUnit unit) adds item to the front of the queue waiting the specified time,
            blockingDeque.offerFirst(0, 5L, TimeUnit.SECONDS);
            printLn(blockingDeque);
            // offerLast(E, e, long timeout, TimeUnit unit) adds item to the tail of the queue waiting the specified time,
            blockingDeque.offerLast(4, 5L, TimeUnit.SECONDS);
            printLn(blockingDeque);
            // pollFirst(long timeout, TimeUnit unit) Retrieves and removes from the Front of the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            printLn(blockingDeque.pollFirst(5L, TimeUnit.SECONDS));
            // pollFirst(long timeout, TimeUnit unit) Retrieves and removes from the tail of the queue
            // waiting the specified time, returning null if the time elapses before the item is available
            printLn(blockingDeque.pollLast(5L, TimeUnit.SECONDS));
            printLn(blockingDeque);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
