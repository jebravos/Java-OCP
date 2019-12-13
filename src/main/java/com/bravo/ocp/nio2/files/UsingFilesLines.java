package com.bravo.ocp.nio2.files;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsingFilesLines {


  public static void main(String[] args) throws IOException {

    Path p = Paths.get(".gitignore");
    try (Stream<String> lines = Files.lines(p)) {
      lines.forEach(PrintUtils::println);
    }
    println("------");
    try (Stream<String> lines = Files.lines(p)) {
      lines.forEach(PrintUtils::println);
    }
  }

}
