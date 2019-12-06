package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.TestDataUtils.NAMES;
import static com.bravo.ocp.utils.TestDataUtils.WORDS;
import static java.util.Map.Entry.comparingByValue;

import com.bravo.ocp.utils.PrintUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static void main(String[] args) {
        CollectingResults cr = new CollectingResults();
//        cr.collectToListNSet();
//        cr.collectWithGroupBy();
        cr.collectToAMap();
//        cr.mostUsedWord();
//        cr.collectUsingPartitioningBy();
//        cr.collectUsingOtherCollectors();
    }

    private void collectToListNSet() {
        Predicate<String> startsWithP = s -> s.startsWith("P");
        Stream<String> sNames = Stream.of(NAMES);
        List<String> namesList = sNames.filter(startsWithP).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        PrintUtils.println("Collecting to a custom list. Names starting by P: {}", namesList);
        Stream<String> sNames2 = Stream.of(NAMES);
        List<String> namesList2 = sNames2.filter(startsWithP).collect(Collectors.toList());
        PrintUtils.println("Collecting using Collectors.toList(). Names starting by P: {}", namesList2);
        Stream<String> sNames3 = Stream.of(NAMES);
        TreeSet<String> namesSet = sNames3.filter(startsWithP).collect(TreeSet::new, Set::add, Set::addAll);
        PrintUtils.println("Collecting to a TreeSet. Names starting by P: {} should be sorted", namesSet);
        PrintUtils.println("---------------------------------------------------");
    }

    private void collectWithGroupBy() {
        Stream<String> sNames = Stream.of(NAMES);
        // Mapping name size to names list
        // Grouping using a List
        Map<Integer, List<String>> nameLengthToNameMap = sNames.collect(Collectors.groupingBy(String::length));
        PrintUtils.println("Collecting using gropingBy nameLengthToNameMap: {}", nameLengthToNameMap);
        // Grouping using a set
        Stream<String> sNames2 = Stream.of(NAMES);
        Map<Integer, Set<String>> nameLengthToNameSetMap = sNames2.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        PrintUtils.println("Collecting using gropingBy grouping in a set nameLengthToNameSetMap: {}", nameLengthToNameSetMap);
        // Grouping using a TreeSet into a TreeMap. Result should be sorted
        Stream<String> sNames3 = Stream.of(NAMES);
        Map<Integer, Set<String>> nameLengthToNameSortedSetTreeMap = sNames3.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
        PrintUtils.println("Collecting using gropingBy into a TreeMap grouping in a TreeSet nameLengthToNameSortedSetTreeMap, Names should be sorted:  {}", nameLengthToNameSortedSetTreeMap);
        PrintUtils.println("---------------------------------------------------");
    }

    private void collectToAMap() {
        Stream<String> sNames = Stream.of(NAMES);
        // Name - length name map
        Map<String, Integer> nameToLengthMap = sNames.distinct().collect(Collectors.toMap(s -> s, String::length));
        PrintUtils.println("Collecting into a map nameToLengthMap: {}", nameToLengthMap);
        Stream<String> sNames2 = Stream.of(NAMES);
        TreeMap<String, Integer> sortedNameToLengthMap = sNames2
                .distinct()
                .collect(Collectors.toMap(s -> s, String::length, (i, i2) -> i, TreeMap::new));
        PrintUtils.println("Collecting into a TreeMap sortedNameToLengthMap: {}", sortedNameToLengthMap);
        PrintUtils.println("---------------------------------------------------");

    }

    private void collectUsingPartitioningBy() {
        Stream<String> sNames = Stream.of(NAMES);
        Map<Boolean, List<String>> nameSizeGreaterThan5Map = sNames
                .collect(Collectors.partitioningBy((String s) -> s.length() > 5));
        PrintUtils.println("Collecting using partitioningBy (not repeated names) nameSizeGreaterThan5Map: {}", nameSizeGreaterThan5Map);

        Stream<String> sName2 = Stream.of(NAMES);
        Map<Boolean, Set<String>> nameSizeGreaterThan5Map2 = sName2
                .collect(Collectors.partitioningBy((String s) -> s.length() > 5, Collectors.toSet()));
        PrintUtils.println("Collecting using partitioningBy grouping in a set (not repeated names) nameSizeGreaterThan5Map: {}", nameSizeGreaterThan5Map2);

        Stream<String> sName3 = Stream.of(NAMES);
        Map<Boolean, TreeSet<String>> nameSizeGreaterThan5Map3 = sName3
                .collect(Collectors.partitioningBy((String s) -> s.length() > 5, Collectors.toCollection(TreeSet::new)));
        PrintUtils.println("Collecting using partitioningBy grouping in a TreeSet (not repeated names, sorted) nameSizeGreaterThan5Map: {}", nameSizeGreaterThan5Map3);

        PrintUtils.println("---------------------------------------------------");

    }

    private void collectUsingOtherCollectors() {
        Stream<String> sNames = Stream.of(NAMES);
        String joinedString = sNames.collect(Collectors.joining());
        PrintUtils.println("Collecting using joining: {}", joinedString);

        Stream<String> sNames2 = Stream.of(NAMES);
        String joinedStringCommaSeparated = sNames2.collect(Collectors.joining(","));
        PrintUtils.println("Collecting using joining separated by , : {}", joinedStringCommaSeparated);

        Stream<String> sNames3 = Stream.of(NAMES);
        Optional<String> minName = sNames3.collect(Collectors.minBy(Comparator.naturalOrder()));
        PrintUtils.println("Collecting minBy: {}", minName.get());

        Stream<String> sNames4 = Stream.of(NAMES);
        Optional<String> maxLengthName = sNames4.collect(Collectors.maxBy(Comparator.comparingInt(String::length)));
        PrintUtils.println("Collecting maxBy the longest name: {}", maxLengthName.get());

        Stream<String> sNames5 = Stream.of(NAMES);
        Long namesCount = sNames5.collect(Collectors.counting());
        PrintUtils.println("Collecting counting namesCount: {}", namesCount);
        PrintUtils.println("---------------------------------------------------");

    }

    private void mostUsedWord() {
        Stream<String> sWords = Stream.of(WORDS);
        TreeMap<String, Long> wordToWordRepetitionMap = sWords
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        PrintUtils.println("wordToWordRepetitionMap :" + wordToWordRepetitionMap);
        LinkedHashMap<String, Long> sortedWordToRepetitionMap = wordToWordRepetitionMap
                .entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o2) -> o, LinkedHashMap::new));
        PrintUtils.println("sortedWordToRepetitionMap: " + sortedWordToRepetitionMap);
        sortedWordToRepetitionMap.entrySet()
                .stream().findFirst()
                .ifPresent(x -> PrintUtils.println("Most repeated word: {}", x));
        PrintUtils.println("---------------------------------------------------");
    }
}
