package collections_and_generics;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class TestingQueues {

    public static void main(String[] args) {
        TestingQueues tq = new TestingQueues();

        tq.testingQueue();
    }


    public void testingQueue() {
        //ArrayDeque is double ended queue and it stores the elements in a resizable array
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // boolean add(E e) adds elements to the back of the queue and returns true or throws an exception.
        System.out.println("add 10 " + queue.add(10));
        System.out.println("add 11 " + queue.add(11));
        System.out.println("queue: " + queue);
        System.out.println("add 15 " + queue.add(15));
        System.out.println("add 12 " + queue.add(12));
        System.out.println("queue: " + queue);

        //ArrayDeque doesn't allows null elements
        try{
            queue.add(null);
        } catch (NullPointerException e ){
            System.out.println(e.getClass() + " null elements are not allowed in ArrayDeque");
        }

        // E elemenet() returns next element or throw an exception if empty queue
        // The element returned is not remove from the queue
        System.out.println("element: " + queue.element());
        System.out.println("queue: " + queue);
        try{
            new ArrayDeque<>().element();
        } catch (NoSuchElementException e ){
            System.out.println(e.getClass() + " applying element() on empty queue");
        }

        // boolean offer(E e) Adds and element to the back of the queue and returns whether successful
        System.out.println("offer 1000: " + queue.offer(100)); // true
        System.out.println("queue: " + queue); // [10 11 15 12 100]

        // E remove() removers and return next element
        System.out.println("remove: " + queue.remove()); // 10
        System.out.println("queue: " + queue); // [11 15 12 100]
        try{
            new ArrayDeque<>().remove();
        } catch (NoSuchElementException e ){
            System.out.println(e.getClass() + " applying remove() on empty queue");
        }


        // void push(E e) adds an element to the front of the queue
        // Push is what makes it a double-ended queue
        System.out.println("push 0: ");
        queue.push(0);
        System.out.println("queue: " + queue); // [0, 11 15 12 100]

        // E poll() removes and returns next element or return null if empty queue
        System.out.println("poll: " + queue.poll()); // 0
        System.out.println("queue: " + queue); // [11 15 12 100]
        System.out.println("poll on empty queue: " + new ArrayDeque<>().poll());


        //E peek() returns next element or null if empty queue
        System.out.println("peek: " + queue.peek()); // 11
        System.out.println("queue: " + queue); // [11 15 12 100]
        System.out.println("peek on empty queue: " + new ArrayDeque<>().peek());

        //E pop() Removes and retunr next element or throws an exception if empty queue
        System.out.println("pop: " + queue.pop()); // 11
        System.out.println("queue: " + queue); // [15 12 100]
        try{
            new ArrayDeque<>().pop();
        } catch (NoSuchElementException e ){
            System.out.println(e.getClass() + " applying pop() on empty queue");
        }


    }
}
