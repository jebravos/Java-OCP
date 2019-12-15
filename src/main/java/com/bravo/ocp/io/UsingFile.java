package com.bravo.ocp.io;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.PrintUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class UsingFile {

  public static void main(String[] args) {

    final String homePath = "home/";
    final String testFilePath = homePath + "test.txt";

    File home = new File(homePath);
    File test = new File(testFilePath);

    createHomeIfDoesntExist(home);
    createTestFile(test);

    listDirectoryFiles(home);

    Arrays.stream(home.listFiles((dir, name) -> testFilePath.endsWith(name)))
        .forEach(file -> println("{} was renamed? {}",file, file.renameTo(new File(homePath + "test2.txt"))));

    listDirectoryFiles(home);

    File test2 = new File("home/test2.txt");
    // rename to itself it's not successfully done
    println("was renamed? {}", test.renameTo(test2));

    deleteDirectory(home);
  }

  private static void deleteDirectory(File toDelete) {
    if(toDelete.isDirectory()){
      File[] files = toDelete.listFiles();
      if(files != null){
        Arrays.stream(files).forEach(File::delete);
      }
    }

    println("{} was deleted? {}", toDelete, toDelete.delete());
  }

  private static void listDirectoryFiles(File home) {
    File[] files = home.listFiles();

    if(files!= null){
      Arrays.stream(files)
          .forEach(PrintUtils::println);
    }
  }

  private static void createHomeIfDoesntExist(File home) {
    if (home.exists()) {
      println("home already exists");
    } else {
      home.mkdir();
    }
  }

  private static void createTestFile(File test) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(test))) {
      IOUtils.writeLine(bw, "Hello world!!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
