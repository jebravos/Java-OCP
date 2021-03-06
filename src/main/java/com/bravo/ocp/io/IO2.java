package com.bravo.ocp.io;

import com.bravo.ocp.utils.PrintUtils;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;

import static com.bravo.ocp.utils.PrintUtils.err;
import static java.io.File.separator;
import static com.bravo.ocp.io.IOBasics.HOME;
import static com.bravo.ocp.utils.PrintUtils.println;

public class IO2 {


    public static void main(String[] args) throws FileNotFoundException {

        writeObjectToFile();
        readObjectFromFile();

    }

    private static void readObjectFromFile() {
        final File file = new File(HOME + separator + "/TEST_IO/Esteban_31.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                Object object = objectInputStream.readObject();
                PrintUtils.println(object);
            }

        } catch (EOFException e) {
            PrintUtils.println("read has ended!!!");
        } catch (IOException e) {
            err(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectToFile() {
        Person esteban = new Person("Esteban", LocalDate.of(1988, 1, 20));
        final File file = new File(HOME + separator + "/TEST_IO/" + esteban.getName() + "_" + esteban.getAge() + ".txt");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(esteban);
        } catch (IOException e) {
            err(e.getMessage());
        }
    }

}


class Person implements Serializable {

    private final static long serialVersionUID = 1L;

    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "{ "
                + "\"name\" : " + this.name + ","
                + "\"birthDate\" : " + this.birthDate.toString()
                + "}";
    }
}

