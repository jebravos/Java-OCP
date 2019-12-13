package com.bravo.ocp.io.fundamentals;

import static com.bravo.ocp.utils.PrintUtils.println;
import static com.bravo.ocp.utils.TestDataUtils.NAMES;

import com.bravo.ocp.utils.PrintUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsingPrintWriter {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get("usingPrintWriter.txt");

    try (OutputStream os = new FileOutputStream(path.toFile())) {
      println("writing on {}....", path);
      PrintWriter pw = new PrintWriter(os);
      //
      usingPrintWriter(pw);
      //
      printFileLines(path);

    } finally {
      Files.deleteIfExists(path);
    }
  }

  private static void usingPrintWriter(PrintWriter pw) {
    Stream.of(NAMES)
        .forEach(s -> {
          // write and print don't throw any exception in case of failure, it set an error variable that can be checked with pw.checkError()
          pw.write(s);
          pw.println();
        });

    // pw.print(null) manages null values printing "null"
    pw.println((String) null);
    try {
      // pw.write(null) throws a NullPointerException
      pw.write((String) null);
    } catch (NullPointerException e) {
      e.printStackTrace();
    }

    pw.println(new MyClass());

    println("Has been an Error? {}", pw.checkError());
  }

  private static void printFileLines(Path path) throws IOException {
    try(Stream<String> lines = Files.lines(path)){
      lines.forEach(PrintUtils::println);
    }
  }

  private static class MyClass {

  }

}
