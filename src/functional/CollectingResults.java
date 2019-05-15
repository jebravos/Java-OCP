package functional;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class CollectingResults {

    private final String[] names = new String[]{"Jorge", "Esteban", "Maria", "Camila", "Diana", "Patricia", "Paula", "Jose", "Esteban", "Patricia"};
    private final String[] words = new String[]{"hello", "world", "java", "java", "java", "hello", "world", "java", "hello", "rules"};

    public static void main(String[] args) {
        CollectingResults cr = new CollectingResults();
        cr.collectToListNSet();
        cr.collectWithGroupBy();
        cr.collectToAMap();
        cr.mostUsedWord();
    }

    private void collectToListNSet() {
        Predicate<String> startsWithP = s -> s.startsWith("P");
        Stream<String> sNames = Stream.of(names);
        List<String> namesList = sNames.filter(startsWithP).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Collecting to a custom list. Names starting by P: " + namesList);
        Stream<String> sNames2 = Stream.of(names);
        List<String> namesList2 = sNames2.filter(startsWithP).collect(Collectors.toList());
        System.out.println("Collecting using Collectors.toList(). Names starting by P: " + namesList2);
        Stream<String> sNames3 = Stream.of(names);
        TreeSet<String> namesSet = sNames3.filter(startsWithP).collect(TreeSet::new, Set::add, Set::addAll);
        System.out.println("Collecting to a TreeSet. Names starting by P: " + namesSet + " should be sorted");
        System.out.println("---------------------------------------------------");
    }

    private void collectWithGroupBy() {
        Stream<String> sNames = Stream.of(names);
        // Mapping name size to names list
        // Grouping using a List
        Map<Integer, List<String>> nameLengthToNameMap = sNames.collect(Collectors.groupingBy(String::length));
        System.out.println("nameLengthToNameMap: " + nameLengthToNameMap);
        // Grouping using a set
        Stream<String> sNames2 = Stream.of(names);
        Map<Integer, Set<String>> nameLengthToNameSetMap = sNames2.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("nameLengthToNameSetMap: " + nameLengthToNameSetMap);
        // Grouping using a TreeSet into a TreeMap. Result should be sorted
        Stream<String> sNames3 = Stream.of(names);
        Map<Integer, Set<String>> nameLengthToNameSortedSetTreeMap = sNames3.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
        System.out.println("nameLengthToNameSortedSetTreeMap, Names should be sorted:  " + nameLengthToNameSortedSetTreeMap);
        System.out.println("---------------------------------------------------");
    }

    private void collectToAMap() {
        Stream<String> sNames = Stream.of(names);
        // Name - length name map
        Map<String, Integer> nameToLengthMap = sNames.distinct().collect(Collectors.toMap(s -> s, String::length));
        System.out.println("nameToLengthMap: " + nameToLengthMap);
        Stream<String> sNames2 = Stream.of(names);
        TreeMap<String, Integer> sortedNameToLengthMap = sNames2
            .distinct()
            .collect(Collectors.toMap(s -> s, String::length, (i, i2) -> i, TreeMap::new));
        System.out.println("sortedNameToLengthMap: " + sortedNameToLengthMap);
        System.out.println("---------------------------------------------------");

    }


    private void mostUsedWord() {
        Stream<String> sWords = Stream.of(words);
        TreeMap<String, Long> wordToWordRepetitionMap = sWords
            .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        System.out.println("wordToWordRepetitionMap :" + wordToWordRepetitionMap);
        LinkedHashMap<String, Long> sortedWordToRepetitionMap = wordToWordRepetitionMap
            .entrySet()
            .stream()
            .sorted(comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o2) -> o, LinkedHashMap::new));
        System.out.println("sortedWordToRepetitionMap: " + sortedWordToRepetitionMap);
        sortedWordToRepetitionMap.entrySet()
            .stream().findFirst()
            .ifPresent(x -> System.out.println("Most repeated word: " + x));
        System.out.println("---------------------------------------------------");
        Stream<String> s = Stream.of(words);


    }
}
