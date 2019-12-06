package com.bravo.ocp.exceptions_and_assertions;

public class ExceptionsThrownBySubclasses {


}


class ParentClass{

  // Any overriding method must not throw a new Exception or a more generic Exception
  // Any overriding method should throw the same exception as defined in original method, or a more specific exception (a subclass) or not throw nothing at all
  // Or any RuntimeException or Error (Since it is a Throwable)
  public void aMethod() throws MyException{
    // .. lots of code
  }

  public void aMethodThrowsAnAssertionError() throws AssertionError {
    //... lots of code
  }

  // An error has no need to ne declared on method signature
  public void aMethodThrowsAnError(){
    //... lots of code
    throw  new Error();
  }



}

class ChildClass extends ParentClass{

  @Override
  // Any of these options will work
//  public void aMethod() throws MyException{
  public void aMethod() throws MyChildException{ // A subclass of the original exception (more specific exception)
//  public void aMethod() throws NullPointerException{ // RuntimeException
//  public void aMethod() throws Error{ // Error is a Throwable
//  public void aMethod(){ // nothing

    //Lots of code
  }

  @Override
  public void aMethodThrowsAnAssertionError() throws AssertionError {
//  public void aMethodThrowsAnAssertionError() {
//  public void aMethodThrowsAnAssertionError() throws RuntimeException {


    // ...Lots of code
  }
}

class MyException extends Exception{
}

class MyChildException extends MyException{
}

class MyOtherException extends Exception{
}



