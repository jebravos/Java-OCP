package ocp.collections_and_generics;

import ocp.utils.CommonUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static ocp.utils.CommonUtils.println;

public class TestingTreeSet {

    public static void main(String[] args) {

        TestingTreeSet tts = new TestingTreeSet();
        tts.testingTreeSet();

    }

    private void testingTreeSet() {

        // TreeSet implements NavigableSet interface which extends from SortedSet
        // TreeSet uses a TreeMAp to store data
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(100);
        treeSet.add(15);
        treeSet.add(67);
        treeSet.add(28);
        treeSet.add(4);

        CommonUtils.println(treeSet);

        // NavigableSet interface which provides some interesting methods:
        // E lower(E e) Returns greatest element that is < e, or null if no such element
        println("lower: {}", treeSet.lower(50));
        // E floor(E e) Returns greatest element that is <= e, or null if no such element
        println("floor: {}", treeSet.floor(50));
        // E ceiling(E e) Returns smallest element that is >= e, or null if no such element
        println("ceiling: {}", treeSet.ceiling(50));
        // E higher(E e) Returns smallest element that is > e, or null if no such element
        println("heigher: {}", treeSet.higher(50));


        // SortedSet methods
        println("first {}", treeSet.first());
        println("last {}", treeSet.last());

        // TreeSet cannot contain null values. It will throw a NullPointerException
        try {
            treeSet.add(null);
        } catch (NullPointerException e) {
            CommonUtils.println("TreeSet cannot contain null values. It will throw a NullPointerException");
        }

        println("poll first {} treeSet: {}", treeSet.pollFirst(), treeSet);
        println("poll last {} treeSet {} ", treeSet.pollLast(), treeSet);
        CommonUtils.println("-------------------------------------------------------------");

        // If we use a collection to create a new TreeSet instance, the result set will be sorted according to the natural order of its elements
        List<Integer> numbers = Arrays.asList(3, 2, 5, 1, 3, 8, 7);
        TreeSet<Integer> numberTree = new TreeSet<>(numbers);
        CommonUtils.println(numberTree);

        // Objects in a TreeSet should be comparable. They must implement Comparable or whe can define a comparator in the TreeSet constructor
        // TreeSet<Elephant> elephants = new TreeSet<>(); // This will compile but a ClassCastException is thrown in elephants.add
        TreeSet<Elephant> elephants = new TreeSet<>(Comparator.comparing(Elephant::getName));
        elephants.add(new Elephant("carlos"));
        elephants.add(new Elephant("alberto"));
        elephants.add(new Elephant("benito"));

        CommonUtils.println(elephants);


    }

}
