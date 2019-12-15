package com.bravo.ocp.concurrency.executors;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.ExecutorsUtils;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class ExecutorServiceRunnableCallable {

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = null;

    try{
      executorService = Executors.newSingleThreadExecutor();

      executorService.submit(new RandomNumberPrinter(15, 50, 10));
      Future<Integer> sumFuture = executorService.submit(new SumCalculator(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
      println("sum is {}", sumFuture.get());


    } catch (ExecutionException e) {
      e.printStackTrace();
    } finally {
      ExecutorsUtils.shutdownExecutorAndReport(executorService, 10);
    }

  }

}

class RandomNumberPrinter implements  Runnable {

  int lowerBound;
  int upperBound;
  int repetitions;

  public RandomNumberPrinter(int lowerBound, int upperBound, int repetitions) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.repetitions = repetitions;
  }

  @Override
  public void run() {
    for(int i = 0; i < repetitions; i++){
      println(ThreadLocalRandom.current().nextInt(lowerBound, upperBound));
    }
  }
}


class SumCalculator implements Callable<Integer> {

  final Integer[] ints;

  SumCalculator(Integer[] ints) {
    this.ints = ints;
  }

  @Override
  public Integer call() throws Exception {
    return Arrays.stream(ints)
        .mapToInt(i -> i)
        .sum();
  }
}