package com.bravo.ocp.javastreamapi.collectors;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.javastreamapi.collectors.UsingGroupBy.Course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsingToMap {

  public static void main(String[] args) {
    List<Course> courses = Arrays.asList(new Course("Java", "Java for dummies"),
        new Course("Java", "Java for experts"),
        new Course("Java", "Java OCP"),
        new Course("C#", "C#"),
        new Course("C#", "C# for dummies")
    );

    courses.stream()
        .collect(Collectors.toMap(Course::getCategory, Arrays::asList, (objects, objects2) -> new ArrayList<>(objects2)))
        .forEach((k, v) -> println(v));
  }

}
