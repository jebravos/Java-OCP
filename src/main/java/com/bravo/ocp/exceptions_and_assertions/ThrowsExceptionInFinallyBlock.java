package com.bravo.ocp.exceptions_and_assertions;

import static com.bravo.ocp.utils.PrintUtils.println;

public class ThrowsExceptionInFinallyBlock {

  public static void main(String[] args) {

    try {
      m1();
    } catch (Exception e) {

      Throwable[] suppressed = e.getSuppressed();

      // This block won't print anything since there are no suppressed exceptions
      for (Throwable t: suppressed) {
        println(t);
      }

      e.printStackTrace();
    }

  }

  private static void m1() throws Exception {
    try{
      m2();
    } finally {
      //Since it is an explicit finally block, the exception thrown in the finally block is the one that is thrown from the method
      // Exception thrown by m2 is lost
      throw new RuntimeException("Exception from finally");
    }
  }

  private static void m2() throws Exception {
    throw new Exception("In m2");
  }

}
