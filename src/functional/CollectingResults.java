package functional;

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
        cr.collectUsingPartitioningBy();
        cr.collectUsingOtherCollectors();
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
        System.out.println("Collecting using gropingBy nameLengthToNameMap: " + nameLengthToNameMap);
        // Grouping using a set
        Stream<String> sNames2 = Stream.of(names);
        Map<Integer, Set<String>> nameLengthToNameSetMap = sNames2.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("Collecting using gropingBy grouping in a set nameLengthToNameSetMap: " + nameLengthToNameSetMap);
        // Grouping using a TreeSet into a TreeMap. Result should be sorted
        Stream<String> sNames3 = Stream.of(names);
        Map<Integer, Set<String>> nameLengthToNameSortedSetTreeMap = sNames3.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
        System.out.println("Collecting using gropingBy into a TreeMap grouping in a TreeSet nameLengthToNameSortedSetTreeMap, Names should be sorted:  " + nameLengthToNameSortedSetTreeMap);
        System.out.println("---------------------------------------------------");
    }

    private void collectToAMap() {
        Stream<String> sNames = Stream.of(names);
        // Name - length name map
        Map<String, Integer> nameToLengthMap = sNames.distinct().collect(Collectors.toMap(s -> s, String::length));
        System.out.println("Collecting into a map nameToLengthMap: " + nameToLengthMap);
        Stream<String> sNames2 = Stream.of(names);
        TreeMap<String, Integer> sortedNameToLengthMap = sNames2
            .distinct()
            .collect(Collectors.toMap(s -> s, String::length, (i, i2) -> i, TreeMap::new));
        System.out.println("Collecting into a TreeMap sortedNameToLengthMap: " + sortedNameToLengthMap);
        System.out.println("---------------------------------------------------");

    }

    private void collectUsingPartitioningBy() {
        Stream<String> sNames = Stream.of(names);
        Map<Boolean, List<String>> nameSizeGreaterThan5Map = sNames
            .collect(Collectors.partitioningBy((String s) -> s.length() > 5));
        System.out.println("Collecting using partitioningBy (not repeated names) nameSizeGreaterThan5Map: " + nameSizeGreaterThan5Map);

        Stream<String> sName2 = Stream.of(names);
        Map<Boolean, Set<String>> nameSizeGreaterThan5Map2 = sName2
            .collect(Collectors.partitioningBy((String s) -> s.length() > 5 , Collectors.toSet()));
        System.out.println("Collecting using partitioningBy grouping in a set (not repeated names) nameSizeGreaterThan5Map: " + nameSizeGreaterThan5Map2);

        Stream<String> sName3 = Stream.of(names);
        Map<Boolean, TreeSet<String>> nameSizeGreaterThan5Map3 = sName3
            .collect(Collectors.partitioningBy((String s) -> s.length() > 5 , Collectors.toCollection(TreeSet::new)));
        System.out.println("Collecting using partitioningBy grouping in a TreeSet (not repeated names, sorted) nameSizeGreaterThan5Map: " + nameSizeGreaterThan5Map3);

        System.out.println("---------------------------------------------------");

    }

    private void collectUsingOtherCollectors(){
        Stream<String> sNames = Stream.of(names);
        String joinedString = sNames.collect(Collectors.joining());
        System.out.println("Collecting using joining: " + joinedString);

        Stream<String> sNames2 = Stream.of(names);
        String joinedStringCommaSeparated = sNames2.collect(Collectors.joining(","));
        System.out.println("Collecting using joining separated by , : " + joinedStringCommaSeparated);

        Stream<String> sNames3 = Stream.of(names);
        Optional<String> minName = sNames3.collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Collecting minBy: " + minName.get());

        Stream<String> sNames4 = Stream.of(names);
        Optional<String> maxLengthName = sNames4.collect(Collectors.maxBy(Comparator.comparingInt(String::length)));
        System.out.println("Collecting maxBy the longest name: " + maxLengthName.get());

        Stream<String> sNames5 = Stream.of(names);
        Long namesCount = sNames5.collect(Collectors.counting());
        System.out.println("Collecting counting namesCount: " + namesCount);
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
    }
}
