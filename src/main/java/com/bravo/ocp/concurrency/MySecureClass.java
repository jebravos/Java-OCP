package com.bravo.ocp.concurrency;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySecureClass {

  public static void main(String[] args) throws InterruptedException {
    MySecureClass msc = new MySecureClass();

    ExecutorService executorService = null;
    try{

      executorService = Executors.newFixedThreadPool(2);
      executorService.submit(msc::doALotOfStuff);
      executorService.submit(msc::doSmallStuff);

    } finally {
      ExecutorsUtils.shutdownExecutorAndReport(executorService, 10);
    }

  }

  // Synchronized methods get the lock on the object
  public synchronized void doALotOfStuff() {
    try {
      LINE1:
      // Thread sleep doesn't release the lock on the object while is sleeping
      Thread.sleep(10000);
    } catch (Exception e) {
    }
  }

  // Synchronized methods get the lock on the object
  public synchronized void doSmallStuff() {
    println("done");
  }

}
