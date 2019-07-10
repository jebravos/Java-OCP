package ocp.io;

import java.io.*;

import static java.io.File.separator;
import static ocp.io.IOUtils.*;
import static ocp.utils.PrintUtils.println;

public class IOBasics {

    public static String HOME = "/home/esteban";

    public static void main(String[] args) {
        // The file class is used to read information about existing files and directories, list contents of a directory and create/delete files and directories
        // It's initialized with a String containing either an absolute or relative path to the file or directory within the file system.

        final File home = new File(HOME );
        println("{} exist? {}", HOME, home.exists());
        println("{} is folder? {}", HOME, home.isDirectory());

        final File file = new File(HOME + separator + "/TEST_IO/file1.txt");
        println("{} exist? {}", HOME + separator + "/TEST_IO/file1.txt", file.exists());
        println("{} is folder? {}", HOME + separator + "/TEST_IO/file1.txt", file.isDirectory());

        final File fileCopy = new File(HOME + separator + "/TEST_IO/file1_copy.txt");
        final File fileCopy2 = new File(HOME + separator + "/TEST_IO/file1_copy2.txt");



        // Try with resources in order to auto-close the resources
        // The resources will be closed in the opposite order
        try (FileReader reader = new FileReader(file);
             FileInputStream fileInputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(fileCopy);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCopy2))) {

            readAndPrintInConsole(reader);
            println("----------------");
//            readAndPrintInConsole(fileInputStream);
            readAndAcceptConsumer(fileInputStream, write(writer));
            println("----------------");
//            readLineAndPrintInConsole(bufferedReader);
            readLinesAndAcceptConsumer(bufferedReader, writeLine(bufferedWriter));
            println("----------------");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
