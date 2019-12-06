package com.bravo.ocp.nio2.files;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.io.IOUtils;
import com.bravo.ocp.utils.FilesUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UsingFilesIsSameFile {


  public static void main(String[] args) throws IOException {
    initFiles();
    //
    Path path1 = Paths.get("myTestFile.txt");
    Path path2 = Paths.get("myTestFile2.txt");

    // It will copy the file on path1 into path2
    // By default the copy fails if the target exists, but StandardCopyOption.REPLACE_EXISTING makes the copy to overwrite the existing file
    Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

    println("{} exists? {}", path2, Files.exists(path2));
    // Even the content of both files are the same this should print false since Files.isSameFile validates that both paths references the same Path object, and it is not the case
    println("{} and {} are same file? {}", path1, path2, Files.isSameFile(path1, path2));

    // Removing files
    FilesUtils.delete(path1);
    FilesUtils.delete(path2);

  }

  private static void initFiles() {
    createTxtFile("myTestFile.txt", "Hello world!!");
  }

  private static void createTxtFile(String fileName, String lineContent) {
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
      IOUtils.writeLine(bw, lineContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
