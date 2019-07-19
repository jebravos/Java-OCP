package com.bravo.ocp.collections_and_generics;

import com.bravo.ocp.utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static com.bravo.ocp.utils.PrintUtils.println;

public class TestingQueues {

    public static void main(String[] args) {
        TestingQueues tq = new TestingQueues();

        tq.testingQueue();
    }


    private void testingQueue() {
        //ArrayDeque is double ended queue and it stores the elements in a resizable array
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // boolean add(E e) adds elements to the back of the queue and returns true or throws an exception.
        // (back)(tail) |e|1|3|4|3|5|6|7|9| (head)
        PrintUtils.println("add 10 " + queue.add(10));
        PrintUtils.println("add 11 " + queue.add(11));
        PrintUtils.println("queue: " + queue);
        PrintUtils.println("add 15 " + queue.add(15));
        PrintUtils.println("add 12 " + queue.add(12));
        PrintUtils.println("queue: " + queue);

        //ArrayDeque doesn't allows null elements
        try{
            queue.add(null);
        } catch (NullPointerException e ){
            PrintUtils.println("{} null elements are not allowed in ArrayDeque", e.getClass());
        }

        // E element() returns next element or throw an exception if empty queue
        // The element returned is not remove from the queue
        PrintUtils.println("element: {}", queue.element());
        PrintUtils.println("queue: {}", queue);
        try{
            new ArrayDeque<>().element();
        } catch (NoSuchElementException e ){
            PrintUtils.println("{} applying element() on empty queue", e.getClass());
        }

        // boolean offer(E e) Adds and element to the back of the queue and returns whether successful
        // (back)(tail) |e|1|3|4|3|5|6|7|9| (head)
        PrintUtils.println("offer 1000: {}", queue.offer(100)); // true
        PrintUtils.println("queue: {}", queue); // [10 11 15 12 100]

        // E remove() removes and return next element
        PrintUtils.println("remove: {}", queue.remove()); // 10
        PrintUtils.println("queue: {}", queue); // [11 15 12 100]
        try{
            new ArrayDeque<>().remove();
        } catch (NoSuchElementException e ){
            PrintUtils.println(e.getClass() + " applying remove() on empty queue");
        }


        // void push(E e) adds an element to the front of the queue
        // Push is what makes it a double-ended queue
        PrintUtils.println("push 0: ");
        queue.push(0);
        PrintUtils.println("queue: {}", queue); // [0, 11 15 12 100]

        // E poll() removes and returns next element or return null if empty queue
        PrintUtils.println("poll: {}", queue.poll()); // 0
        PrintUtils.println("queue: {}", queue); // [11 15 12 100]
        PrintUtils.println("poll on empty queue: {}", new ArrayDeque<>().poll());


        //E peek() returns next element or null if empty queue
        PrintUtils.println("peek: {}", queue.peek()); // 11
        PrintUtils.println("queue: {}",  queue); // [11 15 12 100]
        PrintUtils.println("peek on empty queue: {}", new ArrayDeque<>().peek());

        //E pop() Removes and return next element or throws an exception if empty queue
        PrintUtils.println("pop: {}", queue.pop()); // 11
        PrintUtils.println("queue: {}",  queue); // [15 12 100]
        try{
            new ArrayDeque<>().pop();
        } catch (NoSuchElementException e ){
            PrintUtils.println("{} applying pop() on empty queue", e.getClass());
        }


    }
}
