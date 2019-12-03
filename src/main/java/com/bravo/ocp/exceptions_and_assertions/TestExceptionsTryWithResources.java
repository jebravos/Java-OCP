package com.bravo.ocp.exceptions_and_assertions;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.io.IOException;

public class TestExceptionsTryWithResources {

  public static void main(String[] args) throws Exception {
    try (Device d = new Device()) {
      throw new Exception("test");
    }
  }

}

class Device implements AutoCloseable {

  String header = null;

  public void open() throws IOException {
    header = "OPENED";
    println("Device Opened");
    throw new IOException("Unknown");
  }

  public String read() throws IOException {
    return "";
  }

  public void close() {
    println("Closing device");
    header = null;
    throw new RuntimeException("rte");
  }


}
