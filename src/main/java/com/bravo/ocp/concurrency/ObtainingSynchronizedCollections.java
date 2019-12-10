package com.bravo.ocp.concurrency;

import com.bravo.ocp.utils.PrintUtils;
import java.util.*;

import static com.bravo.ocp.utils.PrintUtils.println;

public class ObtainingSynchronizedCollections {

    public static void main(String[] args) {

        List<String> nonSynchronizedList = Arrays.asList("a", "b", "c", "d", "e");

        // Besides the concurrent collections, the Concurrency API also includes methods fro obtaining synchronized versions of existing non-concurrent collections objects.
        // These methods, defined in the Collections class, contains synchronized methods that operate on the inputted collection
        // and return a reference that is the same type as the underlying collection
        //
        //When should you use these methods?
        // If you know at the time of creation that your object requires synchronization,
        // then you should use one of the concurrent collection classes.
        // On the other hand if you're given an existing collection that iz not a concurrent class and need to access ir among multiple threads,
        // you can wrap it using methods in the Collections class.
        List<String> synchronizedList = Collections.synchronizedList(nonSynchronizedList);

        println(synchronizedList);


        synchronizedList.parallelStream().forEach(PrintUtils::print);
        println();
        synchronizedList.parallelStream().forEachOrdered(PrintUtils::print);

    }
}