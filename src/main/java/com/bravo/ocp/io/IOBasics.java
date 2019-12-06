package com.bravo.ocp.io;

import com.bravo.ocp.utils.PrintUtils;

import java.io.*;

import static com.bravo.ocp.utils.PrintUtils.err;
import static java.io.File.separator;
import static com.bravo.ocp.utils.PrintUtils.println;

public class IOBasics {

    public static String HOME = "home/";

    public static void main(String[] args) {
        // The file class is used to read information about existing files and directories, list contents of a directory and create/delete files and directories
        // It's initialized with a String containing either an absolute or relative path to the file or directory within the file system.

        final File home = new File(HOME );
        PrintUtils.println("{} exist? {}", HOME, home.exists());
        PrintUtils.println("{} is folder? {}", HOME, home.isDirectory());

        final File file = new File(HOME + separator + "/TEST_IO/file1.txt");
        PrintUtils.println("{} exist? {}", HOME + separator + "/TEST_IO/file1.txt", file.exists());
        PrintUtils.println("{} is folder? {}", HOME + separator + "/TEST_IO/file1.txt", file.isDirectory());

        final File fileCopy = new File(HOME + separator + "/TEST_IO/file1_copy.txt");
        final File fileCopy2 = new File(HOME + separator + "/TEST_IO/file1_copy2.txt");


        // Try with resources in order to auto-close the resources
        // The resources will be closed in the opposite order
        try (FileReader reader = new FileReader(file);
             FileInputStream fileInputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(fileCopy);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCopy2))) {

            IOUtils.readAndPrintInConsole(reader);
            PrintUtils.println("----------------");
//            readAndPrintInConsole(fileInputStream);
            IOUtils.readAndAcceptConsumer(fileInputStream, IOUtils.write(writer));
            PrintUtils.println("----------------");
//            readLineAndPrintInConsole(bufferedReader);
            IOUtils.readLinesAndAcceptConsumer(bufferedReader, IOUtils.writeLine(bufferedWriter));
            PrintUtils.println("----------------");

        } catch (IOException e) {
            err(e.getMessage());
        }

    }

}
