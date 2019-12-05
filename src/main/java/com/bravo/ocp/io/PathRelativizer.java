package com.bravo.ocp.io;

import static com.bravo.ocp.utils.PrintUtils.err;
import static com.bravo.ocp.utils.PrintUtils.println;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathRelativizer {

  public static void main(String[] args) {

    Path absolutePath1 = Paths.get("c:\\temp\\test.txt");
    Path absolutePath2 = Paths.get("c:\\temp\\other.txt");
    Path absolutePath3 = Paths.get("c:\\temp\\second\\other.txt");
    Path relativePath = Paths.get("..\\other.txt");

    PathRelativizer relativizer = new PathRelativizer();
    println("1. relativize 2 absolute paths: {}.relativize({}) :  {}", absolutePath1, absolutePath2,
        relativizer.relativize(absolutePath1, absolutePath2));
    println("2. relativize 2 absolute paths: {}.relativize({}) :  {}", absolutePath1, absolutePath3,
        relativizer.relativize(absolutePath1, absolutePath3));
    println("3. relativize 2 absolute paths: {}.relativize({}) :  {}", absolutePath3, absolutePath1,
        relativizer.relativize(absolutePath3, absolutePath1));

    try {
      println("relativize absolute path with relative path: {}.relativize({}) :  {}", absolutePath1, relativePath,
          relativizer.relativize(absolutePath1, relativePath));
    } catch (IllegalArgumentException e) {
      err("4. relativize absolute path with relative path: {}.relativize({}) :   If only one path has a root, {} is thown", absolutePath1,
          relativePath, e.getClass());
    }

    println("5. relativize absolute path with itself: {}.relativize({}) :  {}  should return an empty path", absolutePath1, absolutePath1, relativizer.relativize(absolutePath1, absolutePath1));

  }

  private Path relativize(Path path1, Path path2) {
    return path1.relativize(path2);
  }

}
