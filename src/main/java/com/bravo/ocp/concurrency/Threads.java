package com.bravo.ocp.concurrency;

import static com.bravo.ocp.utils.PrintUtils.println;

public class Threads {

    public static void main(String[] args) {

        println("Hello from main");
        // We can create a Thread using a Runnable lambda or instance as argument in the Thread constructor
        Thread t = new Thread(() -> println("Hello from thread"));
        // we call start() in the thread to execute the task
        t.start();
        // new Thread using a class extending Thread class
        Thread myThread = new MyThread();
        // dont forget to call start() method on the thread object
        myThread.start();
        println("Bye!!!");

    }

}

// We can create new thread classes extending the the Thread class and overriding it's run method
class MyThread extends Thread{

    @Override
    public void run() {
        println("Hello from my thread");
    }
}