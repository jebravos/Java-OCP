package com.bravo.ocp.nio2.files;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFilesLines {


  public static void main(String[] args) throws IOException {

    Path p = Paths.get(".gitignore");
    Files.lines(p).forEach(PrintUtils::println);
    println("------");
    Files.lines(p, Charset.defaultCharset()).forEach(PrintUtils::println);

  }

}
