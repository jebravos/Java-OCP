package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsingGroupBy {


  public static void main(String[] args) {

    List<Course> courses = Arrays.asList(new Course("Java", "Java for dummies"),
        new Course("Java", "Java for experts"),
        new Course("Java", "Java OCP"),
        new Course("C#", "C#"),
        new Course("C#", "C# for dummies")
    );

    courses.stream()
        // groupingBy expects a Function and returns a Collector to group elements in a Map
        .collect(Collectors.groupingBy(Course::getCategory))
        .forEach((m, n) -> println("{}", n));

  }

}


class Course {

  final String category;
  final String name;

  Course(String category, String name) {
    this.category = category;
    this.name = name;
  }

  @Override
  public String toString() {
    return name + " " + category;
  }

  public String getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }
}
