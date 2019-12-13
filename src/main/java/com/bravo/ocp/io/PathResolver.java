package com.bravo.ocp.io;

import static com.bravo.ocp.utils.PrintUtils.err;
import static com.bravo.ocp.utils.PrintUtils.println;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolver {

  public static void main(String[] args) {
    PathResolver pathResolver = new PathResolver();
    Path absolutePath1 = Paths.get("c:\\temp\\test.txt");
    Path absolutePath2 = Paths.get("c:\\temp\\other.txt");
    Path otherAbsolutePath = Paths.get("c:\\temp2\\other.txt");
    Path relativePath1 = Paths.get("temp\\other.txt");
    Path relativePath2 = Paths.get("temp2\\other.txt");


    println( "Resolves two absolute paths: {} .resolve( {} ) = {}",absolutePath1, absolutePath2, pathResolver.resolvePaths(absolutePath1, absolutePath2));
    println( "Resolves two absolute paths {} .resolve( {} ) = {}",absolutePath1, otherAbsolutePath, pathResolver.resolvePaths(absolutePath1, otherAbsolutePath));
    println( "Resolves one absolute path with relative path {} .resolve( {} ) = {}", absolutePath1, relativePath1, pathResolver.resolvePaths(absolutePath1, relativePath1));
    println( "Resolves one absolute path with relative path {} .resolve( {} ) = {}",absolutePath1, relativePath2, pathResolver.resolvePaths(absolutePath1, relativePath2));
    println( "Resolves one relative path with an absolute path {} .resolve( {} ) = {}",relativePath1,absolutePath2, pathResolver.resolvePaths(relativePath1, absolutePath2));
    println( "Resolves one relative path with a relative path {} .resolve( {} ) = {}",relativePath1,relativePath2, pathResolver.resolvePaths(relativePath1, relativePath2));
    println( "Resolves one relative path with itself  {} .resolve( {} ) = {}", relativePath1,relativePath1, pathResolver.resolvePaths(relativePath1, relativePath1));
    println( "Resolves one absolute path with itself  {} .resolve( {} ) = {}", absolutePath1, absolutePath1, pathResolver.resolvePaths(absolutePath1, absolutePath1));

    println( "Resolve siblings {}.resolveSiblings(\"other.txt\") = {}", absolutePath1, absolutePath2, absolutePath1.resolveSibling("other.txt"));

    try{
      pathResolver.resolvePaths(relativePath1, null);
    } catch (NullPointerException e){
      err( "Resolves one relative path with null {} .resolve( null ) = {}", e.toString());
    }

  }

  public Path resolvePaths(Path path1, Path path2){
    return path1.resolve(path2);
  }

}
