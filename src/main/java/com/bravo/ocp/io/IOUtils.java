package com.bravo.ocp.io;

import com.bravo.ocp.utils.PrintUtils;

import java.io.*;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;
import static com.bravo.ocp.utils.PrintUtils.print;

public class IOUtils {

    static void readLinesAndPrintInConsole(BufferedReader bufferedReader) throws IOException {
        readLinesAndAcceptConsumer(bufferedReader, printLineRead());
    }

    static void readLinesAndAcceptConsumer(BufferedReader bufferedReader, Consumer<String> lineConsumer) throws IOException {
        String line;
        while ((line = readNextLine(bufferedReader)) != null) {
            requireNonNull(lineConsumer).accept(line);
        }
    }

    static String readNextLine(BufferedReader bufferedReader) throws IOException {
        return requireNonNull(bufferedReader).readLine();
    }

    static void readAndPrintInConsole(Reader reader) throws IOException {
        readAndAcceptConsumer(reader, printCharacterRead());
    }

    static void readAndPrintInConsole(InputStream inputStream) throws IOException {
        readAndAcceptConsumer(inputStream, printCharacterRead());
    }

    static void readAndAcceptConsumer(Reader reader, Consumer<Integer> characterConsumer) throws IOException {
        int c;
        while ((c = requireNonNull(reader).read()) != -1) {
            characterConsumer.accept(c);
        }
    }

    static void readAndAcceptConsumer(InputStream inputStream, Consumer<Integer> characterConsumer) throws IOException {

        int b;
        while ((b = requireNonNull(inputStream).read()) != -1) {
            if (characterConsumer != null) {
                requireNonNull(characterConsumer).accept(b);
            }
        }
    }

    private static Consumer<Integer> printCharacterRead() {
        return byteRead -> {
            char c = (char) byteRead.intValue();
            PrintUtils.print(c);
        };
    }

    private static Consumer<String> printLineRead() {
        return PrintUtils::println;
    }

    static Consumer<String> writeLine(BufferedWriter bufferedWriter) {
        return line -> writeLine(bufferedWriter, line);
    }

    static Consumer<Integer> write(Writer writer) {
        return byteRead -> {
            char c = (char) byteRead.intValue();
            write(writer, c);
        };
    }

    static void write(Writer writer, char character) {
        try {
            requireNonNull(writer).write(character);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeLine(BufferedWriter bufferedWriter, String line) {
        try {
            requireNonNull(bufferedWriter).write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
