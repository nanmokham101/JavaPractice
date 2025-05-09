package com.mk.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*
process collections of data, offering several compelling advantages:

1. Expressiveness and Readability:
2. Concurrency and Parallelism (with less effort):
3. Functional Programming Concepts:
4. Abstraction over Data Structures:
5. Improved Code Maintainability:
 */
public class StreamDemo {
    /* 1.
        processing sequences of elements.
        A stream() default method is added to the Collection interface and
        allows creating a Stream<T> using any collection as an element source

     */
    String[] arr = new String[]{"a", "b", "c"};
    Stream<String> stream = Arrays.stream(arr);
    Stream<String> stream1 = Stream.of("a", "b", "c");

    /* 2.
        Also providing the parallelStream() method for multithreading that
        runs operations over the stream’s elements in parallel mode.
     */
    static List<String> list = new ArrayList<>();
   // list.parallelStream().forEach(element -> doWork(element));

    /* 3. Iterating
        Substitute for iterating, for-each, and while loops
    */
    public static boolean main(String[] args) {
        for (String string : list) {
            if (string.contains("a")) {
                return true;
            }
        }
        return false;
    }
    /* Matching
       Stream ->  just with one line
       To validate elements of a sequence according to some predicate.
  */

    boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
    boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
    boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
    boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false

    /* 4.   Filtering
        allows to pick a stream of elements that we want to filter
    */
    Stream<String> stream2 = list.stream().filter(element -> element.contains("d"));
}
