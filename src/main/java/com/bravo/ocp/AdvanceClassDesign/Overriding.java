package com.bravo.ocp.AdvanceClassDesign;

import static com.bravo.ocp.utils.PrintUtils.println;

/**
 * Created by Esteban on 3/12/2019.
 */
public class Overriding {

    public static void main(String[] args) {
        Printer simplePrinter = new SimplePrinter();
        simplePrinter.print("hello world");
        simplePrinter.printHello();

        Printer simpleFullPrinter = new FullPrinter();
        simpleFullPrinter.print("hello world");
        simpleFullPrinter.printHello();

        FullPrinter fullFullPrinter = new FullPrinter();
        fullFullPrinter.specialPrint("hello world");
        fullFullPrinter.printHello();

    }

}

class SimplePrinter implements Printer{

    @Override
    public void print(String msg) {
        println("simple: {}", msg);
    }
}

class FullPrinter implements Printer, SpecialPrinter{


    // Here we HAVE TO implement void printHello because FullPrinter cannot inherit from 2 different unrelated interfaces
    @Override
    public void printHello() {
        println("overridden hello");
    }

    @Override
    public void print(String msg) {
        println("full simple: {}", msg);
    }

    @Override
    public void specialPrint(String msg) {
        println("full special: {}", msg );
    }
}

interface Printer {

    default void printHello(){
        println("hello");
    }

    void print(String msg);
}

interface SpecialPrinter {

    default void printHello(){
        println("special hello");
    }

    void print(String msg);

    void specialPrint(String msg);
}
