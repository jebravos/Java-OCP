package com.bravo.ocp.collections_and_generics;

import com.bravo.ocp.utils.PrintUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestingTreeSet {

    public static void main(String[] args) {

        TestingTreeSet tts = new TestingTreeSet();
        tts.testingTreeSet();

    }

    private void testingTreeSet() {

        // TreeSet implements NavigableSet interface which extends from SortedSet
        // TreeSet uses a TreeMap to store data
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(100);
        treeSet.add(15);
        treeSet.add(67);
        treeSet.add(28);
        treeSet.add(4);

        PrintUtils.println(treeSet);

        // NavigableSet interface which provides some interesting methods:
        // E lower(E e) Returns greatest element that is < e, or null if no such element
        PrintUtils.println("lower: {}", treeSet.lower(50));
        // E floor(E e) Returns greatest element that is <= e, or null if no such element
        PrintUtils.println("floor: {}", treeSet.floor(50));
        // E ceiling(E e) Returns smallest element that is >= e, or null if no such element
        PrintUtils.println("ceiling: {}", treeSet.ceiling(50));
        // E higher(E e) Returns smallest element that is > e, or null if no such element
        PrintUtils.println("heigher: {}", treeSet.higher(50));


        // SortedSet methods
        PrintUtils.println("first {}", treeSet.first());
        PrintUtils.println("last {}", treeSet.last());

        // TreeSet cannot contain null values. It will throw a NullPointerException
        try {
            treeSet.add(null);
        } catch (NullPointerException e) {
            PrintUtils.println("TreeSet cannot contain null values. It will throw a NullPointerException");
        }

        PrintUtils.println("poll first {} treeSet: {}", treeSet.pollFirst(), treeSet);
        PrintUtils.println("poll last {} treeSet {} ", treeSet.pollLast(), treeSet);
        PrintUtils.println("-------------------------------------------------------------");

        // If we use a collection to create a new TreeSet instance, the result set will be sorted according to the natural order of its elements
        List<Integer> numbers = Arrays.asList(3, 2, 5, 1, 3, 8, 7);
        TreeSet<Integer> numberTree = new TreeSet<>(numbers);
        PrintUtils.println(numberTree);

        // Objects in a TreeSet should be comparable. They must implement Comparable or whe can define a comparator in the TreeSet constructor
        // TreeSet<Elephant> elephants = new TreeSet<>(); // This will compile but a ClassCastException is thrown in elephants.add
        TreeSet<Elephant> elephants = new TreeSet<>(Comparator.comparing(Elephant::getName));
        elephants.add(new Elephant("carlos"));
        elephants.add(new Elephant("alberto"));
        elephants.add(new Elephant("benito"));

        PrintUtils.println(elephants);


    }

}
