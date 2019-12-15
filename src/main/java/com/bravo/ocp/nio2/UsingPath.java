package com.bravo.ocp.nio2;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPath {

  public static String HOME = "home/esteban";
  public static String RESOURCES = HOME + "/TEST_IO/";

  public static void main(String[] args) throws IOException {
    // Path is intended to replace File
    Path resources = Paths.get(RESOURCES);

    println("resources folder: {}", resources);
    println("resources.startsWith({})? {}", HOME, resources.startsWith(HOME));
    println("resources.startsWith(/{})? {}", HOME, resources.startsWith(Paths.get("/", HOME)));
    println("is absolute: {}", resources.isAbsolute());

    println("Parents:");
    for (int i = 0; i < resources.getNameCount(); i++) {
      println("Element {} is {}", i, resources.getName(i));
    }

    println("resources root: {}", resources.getRoot());
    println("resources file name: {}", resources.getFileName());
    println("resources parent: {}", resources.getParent());

    Path homePath = resources.subpath(0, 1);
    println("home path got with resources.subPath(): {}", homePath);


  }

}
