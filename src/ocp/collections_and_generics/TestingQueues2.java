package ocp.collections_and_generics;

import java.util.ArrayDeque;
import java.util.Queue;

public class TestingQueues2 {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        System.out.println(queue.element());
    }

    private static void printQueueContent(Queue<Integer> queue) {
        System.out.println("queue: " + queue);
    }

}
