package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorsAndCyclicBarrier {

  public static void main(String[] args) {
    final List<String> persons = Arrays.asList("Esteban", "Diana", "Pedro", "Felipe");

    // Create the executors who will execute the tasks
    // This creates a Thread to greet each person
    final ExecutorService executorService = Executors.newFixedThreadPool(persons.size());

    //Creates the barrier which will wait till all the persons have been greeted to serves the dinner and shut down the executor
    final CyclicBarrier cb = new CyclicBarrier(persons.size(), () -> {
      println("Dinner's ready");
      shutdownExecutor(executorService);
    });

    persons.forEach(p -> {
      println("{} has arrived", p);
      println("{} has been arrived", cb.getNumberWaiting());
      executorService.submit(new SayHello(p, cb));

    });

  }

  private static void shutdownExecutor(ExecutorService executorService) {
    try {
      ExecutorsUtils.shutdownExecutorAndReport(executorService, 2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SayHello implements Runnable {

  private final String person;
  private final CyclicBarrier cb;

  SayHello(String person, CyclicBarrier cb) {
    this.person = person;
    this.cb = cb;
  }

  @Override
  public void run() {
    try {
      println("Preparing greeting... ");
      Thread.sleep(1000);
      println("Hello {} ", person);
      cb.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}