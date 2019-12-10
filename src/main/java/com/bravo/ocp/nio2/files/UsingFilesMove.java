package com.bravo.ocp.nio2.files;

import static com.bravo.ocp.utils.PrintUtils.err;
import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.io.IOUtils;
import com.bravo.ocp.utils.FilesUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UsingFilesMove {

  public static void main(String[] args) throws IOException {
    initFiles();
    //
    Path path1 = Paths.get("myTestFile.txt");
    Path another = Paths.get("another/");
    Path path2 = another.resolve("myTestFile.txt");

    // This will throw an exception since the targer already exists
    try{
      Files.move(path1, path2);
    }catch (FileAlreadyExistsException e){
      e.printStackTrace();
    }

    // This actually moves the file source to target replacing the existent file, so no Exception will be thrown
    Files.move(path1, path2, StandardCopyOption.REPLACE_EXISTING);

    clearFiles(path1, another, path2);

  }

  private static void clearFiles(Path path1, Path another, Path path2) {
    // Removing files
    FilesUtils.delete(path1);
    FilesUtils.delete(path2);
    FilesUtils.delete(another);
  }

  private static void initFiles() throws IOException {
    createTxtFile("myTestFile.txt", "Hello world!!");
    Files.createDirectories(Paths.get("another/"));
    createTxtFile("another/myTestFile.txt", "Hello world!! another");
  }

  private static void createTxtFile(String fileName, String lineContent) {
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
      IOUtils.writeLine(bw, lineContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
