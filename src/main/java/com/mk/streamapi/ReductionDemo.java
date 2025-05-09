package com.mk.streamapi;

import java.util.*;

/*
     also known as terminal operations, combine the elements of a stream into a single summary result.
     They consume the stream, and after a reduction operation, the stream can no longer be used.
**/
public class ReductionDemo {
    public static void main(String[] args) {

        //1. count(): Returns the number of elements in the stream.
        List<String> colors = Arrays.asList("red", "green", "blue", "yellow");
        long count = colors.stream().count();
        System.out.println("Number of colors: " + count); // Output: Number of colors: 4


        //2. sum(), average(), min(), max(): These operations work on streams of numbers (IntStream, LongStream, DoubleStream).
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum); // Output: Sum: 15

        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        average.ifPresent(avg -> System.out.println("Average: " + avg)); // Output: Average: 3.0

        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        min.ifPresent(m -> System.out.println("Min: " + m)); // Output: Min: 1

        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        max.ifPresent(m -> System.out.println("Max: " + m)); // Output: Max: 5


        //3. reduce(): This is a more general-purpose reduction operation that combines elements of the stream using a provided binary operator.
        List<String> words = Arrays.asList("hello", "world", "java");

        // Concatenate strings with a space
        Optional<String> combined = words.stream().reduce((s1, s2) -> s1 + " " + s2);
        combined.ifPresent(System.out::println); // Output: hello world java

        // Concatenate strings with a comma and a starting value
        String combinedWithStart = words.stream().reduce("Greeting:", (s1, s2) -> s1 + ", " + s2);
        System.out.println(combinedWithStart); // Output: Greeting:, hello, world, java

        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        int product = numbersList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product); // Output: Product: 120
    }
}
