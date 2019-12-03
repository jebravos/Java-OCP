package com.bravo.ocp.io;

import static com.bravo.ocp.utils.PrintUtils.err;
import static com.bravo.ocp.utils.PrintUtils.println;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class PathResolver {

  public static void main(String[] args) {
    PathResolver pathResolver = new PathResolver();
    println( "Resolves two absolute paths {}", pathResolver.resolvePaths(Paths.get("c:\\temp\\test.txt"), Paths.get("c:\\temp\\other.txt")));
    println( "Resolves two absolute paths {}", pathResolver.resolvePaths(Paths.get("c:\\temp\\test.txt"), Paths.get("c:\\temp2\\other.txt")));
    println( "Resolves one absolute path with relative path {}", pathResolver.resolvePaths(Paths.get("c:\\temp\\test.txt"), Paths.get("temp\\other.txt")));
    println( "Resolves one absolute path with relative path {}", pathResolver.resolvePaths(Paths.get("c:\\temp\\test.txt"), Paths.get("temp2\\other.txt")));
    println( "Resolves one relative path with an absolute path {}", pathResolver.resolvePaths(Paths.get("temp\\test.txt"), Paths.get("c:\\temp\\other.txt")));

    try{
      pathResolver.resolvePaths(Paths.get("temp\\test.txt"), null);
    } catch (NullPointerException e){
      err( "Resolves one relative path with null {}", e.toString());
    }

    try{
      pathResolver.resolvePaths(null, Paths.get("temp\\test.txt"));
    } catch (NullPointerException e){
      err( "Resolves null with one relative path {}", e.toString());
    }
  }

  public Path resolvePaths(Path path1, Path path2){
    return path1.resolve(path2);
  }

}
