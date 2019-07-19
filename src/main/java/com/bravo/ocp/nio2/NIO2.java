package com.bravo.ocp.nio2;

import com.bravo.ocp.utils.PrintUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.bravo.ocp.utils.PrintUtils.println;

public class NIO2 {

    public static String HOME = "/home/esteban";
    public static String RESOURCES = HOME + "/TEST_IO/";

    public static void main(String[] args) throws IOException {
        // Path is intended to replace File
        Path resources = Paths.get(RESOURCES);
        PrintUtils.println("resources folder: {}", resources);
        PrintUtils.println("is absolute: {}", resources.isAbsolute());

        PrintUtils.println("Parents:");
        for (int i = 0; i < resources.getNameCount(); i++) {
            PrintUtils.println("Element {} is {}", i, resources.getName(i));
        }

        PrintUtils.println("resources root: {}", resources.getRoot());
        PrintUtils.println("resources file name: {}", resources.getFileName());
        PrintUtils.println("resources parent: {}", resources.getParent());

        Path homePath = resources.subpath(0, 1);
        PrintUtils.println("home path got with resources.subPath(): {}", homePath);


    }

}
