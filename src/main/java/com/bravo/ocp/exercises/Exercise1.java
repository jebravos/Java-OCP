package com.bravo.ocp.exercises;

import com.bravo.ocp.utils.PrintUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.bravo.ocp.utils.PrintUtils.println;

public class Exercise1 {
/*
    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

    Return the element repeated N times.



    Example 1:

    Input: [1,2,3,3]
    Output: 3

    Example 2:

    Input: [2,1,2,5,3,2]
    Output: 2

    Example 3:

    Input: [5,1,5,2,5,3,5,4]
    Output: 5

    Note:

            4 <= A.length <= 10000
            0 <= A[i] < 10000
    A.length is even
*/

    public static void main(String[] args) {

//        int[] input = {1, 2, 3, 3};
        int[] input = {5, 1, 5, 2, 5, 3, 5, 4};
        start(input);
    }

    private static void start(int[] input) {
        Solution s = new Solution();
        println(s.repeatedNTimes(input));
    }

}


class Solution {
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }
//    int repeatedNTimes(int[] A) {
//
//        Instant now = Instant.now();
//
//        Map<Integer, Integer> repetitions = new HashMap<>();
//
//        for (int value : A) {
//            repetitions.put(value, repetitions.getOrDefault(value, 0) + 1);
//        }
//
////        repetitions.keySet().forEach(key ->
////                println("{} - {}", key, repetitions.get(key)));
//
//        Instant later = Instant.now();
//        println("Time difference: {} millis", ChronoUnit.MILLIS.between(now, later));
//
//        return Collections.max(repetitions.entrySet(), (o1, o2) -> o1.getValue() - o2.getValue()).getKey();
//
//    }
}