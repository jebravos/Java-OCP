package com.bravo.ocp.exceptions_and_assertions;

public class ExceptionsMultiCatchEffectivelyFinalParameters {


  public static void main(String[] args) throws Exception {

    try{
      Thread.sleep(1000);
    } catch (InterruptedException | IndexOutOfBoundsException e) {
      // Exceptions in multi catch clause is implicitly final, so e cannot be reassigned
      // e = new InterruptedException(); // won't compile
      e.printStackTrace();
    }


  }

}
