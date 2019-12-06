package com.bravo.ocp.io.fundamentals;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.io.IOUtils;
import com.bravo.ocp.utils.FilesUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsePrintWriter {

  public static void main(String[] args) throws Exception {
    String fileName = "text.txt";

    // If the file text.txt does't exist, then it will be created
    FileWriter fw = new FileWriter(fileName);
    println("File {} exists? {}",fileName, Files.exists(Paths.get(fileName)));

    fw.write("hello");
    // A new write call will append more content
    fw.write("hello!!");

    // Explicit close.
    // A try with resources block could be use at FileWriter fw = new FileWriter(fileName);
    fw.close();
    printFileContent(fileName);

    // Since the file already exists, its content will be overwrote
    try(FileWriter fw2 = new FileWriter(fileName)){
      fw2.write("hello overwrote!!");
    }

    printFileContent(fileName);

    // Removes file
    FilesUtils.delete(Paths.get(fileName));
  }

  private static void printFileContent(String fileName) throws IOException {
    File file = new File(fileName);
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      IOUtils.readLinesAndPrintInConsole(br);
    }
  }

}
