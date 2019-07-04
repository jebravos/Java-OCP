package ocp.io;

import ocp.utils.PrintUtils;

import java.io.*;

import static java.io.File.separator;
import static ocp.io.IOUtils.*;
import static ocp.utils.PrintUtils.println;

public class IOBasics {

    private static String HOME = "/home/esteban";

    public static void main(String[] args) {
        final File file = new File(HOME + separator + "/TEST_IO/file1.txt");
        final File fileCopy = new File(HOME + separator + "/TEST_IO/file1_copy.txt");
        final File fileCopy2 = new File(HOME + separator + "/TEST_IO/file1_copy2.txt");

        PrintUtils.println("File exist? {}", file.exists());
        PrintUtils.println("File is folder? {}", file.isDirectory());


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
            readLinesAndAcceptConsumer(bufferedReader, IOUtils.writeLine(bufferedWriter));
            println("----------------");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
