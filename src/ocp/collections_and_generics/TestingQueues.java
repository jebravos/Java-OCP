package ocp.collections_and_generics;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static ocp.utils.CommonUtils.printLn;

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
        printLn("add 10 " + queue.add(10));
        printLn("add 11 " + queue.add(11));
        printLn("queue: " + queue);
        printLn("add 15 " + queue.add(15));
        printLn("add 12 " + queue.add(12));
        printLn("queue: " + queue);

        //ArrayDeque doesn't allows null elements
        try{
            queue.add(null);
        } catch (NullPointerException e ){
            printLn("{} null elements are not allowed in ArrayDeque", e.getClass());
        }

        // E element() returns next element or throw an exception if empty queue
        // The element returned is not remove from the queue
        printLn("element: {}", queue.element());
        printLn("queue: {}", queue);
        try{
            new ArrayDeque<>().element();
        } catch (NoSuchElementException e ){
            printLn("{} applying element() on empty queue", e.getClass());
        }

        // boolean offer(E e) Adds and element to the back of the queue and returns whether successful
        // (back)(tail) |e|1|3|4|3|5|6|7|9| (head)
        printLn("offer 1000: {}", queue.offer(100)); // true
        printLn("queue: {}", queue); // [10 11 15 12 100]

        // E remove() removes and return next element
        printLn("remove: {}", queue.remove()); // 10
        printLn("queue: {}", queue); // [11 15 12 100]
        try{
            new ArrayDeque<>().remove();
        } catch (NoSuchElementException e ){
            printLn(e.getClass() + " applying remove() on empty queue");
        }


        // void push(E e) adds an element to the front of the queue
        // Push is what makes it a double-ended queue
        printLn("push 0: ");
        queue.push(0);
        printLn("queue: {}", queue); // [0, 11 15 12 100]

        // E poll() removes and returns next element or return null if empty queue
        printLn("poll: {}", queue.poll()); // 0
        printLn("queue: {}", queue); // [11 15 12 100]
        printLn("poll on empty queue: {}", new ArrayDeque<>().poll());


        //E peek() returns next element or null if empty queue
        printLn("peek: {}", queue.peek()); // 11
        printLn("queue: {}",  queue); // [11 15 12 100]
        printLn("peek on empty queue: {}", new ArrayDeque<>().peek());

        //E pop() Removes and return next element or throws an exception if empty queue
        printLn("pop: {}", queue.pop()); // 11
        printLn("queue: {}",  queue); // [15 12 100]
        try{
            new ArrayDeque<>().pop();
        } catch (NoSuchElementException e ){
            printLn("{} applying pop() on empty queue", e.getClass());
        }


    }
}
