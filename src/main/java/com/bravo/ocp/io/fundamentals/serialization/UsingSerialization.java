package com.bravo.ocp.io.fundamentals.serialization;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsingSerialization {


  public static void main(String[] args) throws IOException, ClassNotFoundException {

    serializeTwo(new Two());
    println("deserialized {}", deserializeTwo("One"));

    Files.deleteIfExists(Paths.get("One"));
  }

  private static void serializeTwo(Two two) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("One"))) {
      oos.writeObject(two);
    }
  }

  // In deserialization the class's constructor and instance initializers are not called
  private static Two deserializeTwo(String filepath) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream((filepath)))) {
      return (Two) ois.readObject();
    }
  }
}

// Test the two versions to see different behaviour: When is not serializable, no-args constructor is called when an instance of Two is deserialized
//class One {
class One implements Serializable{

  public static final long serialVersionUID = 1;

  int one;
  int oneone = 10;

  One() {
    println("One constructor {}", one = 1);
  }

}

class Two extends One implements Serializable {

  // Exception if at deserialization serialVersionUID is not the same as the serialVersionUID at serialization
  public static final long serialVersionUID = 1;

  int two;
  // transient and static fields are never serializezd
  transient int twotwo;

  Two() {
    super();
    println("Two constructor {} {}", two = 2, twotwo = 2);
  }

  @Override
  public String toString() {
    return "" + two + " " + twotwo + " - " + one + " " + oneone;
  }

}


