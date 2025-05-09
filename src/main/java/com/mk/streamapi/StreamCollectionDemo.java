package com.mk.streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@Setter
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}

@Getter
@Setter
@AllArgsConstructor
class Book {
    private String title;
    private String genre;
}
@Getter
@Setter
@AllArgsConstructor
class NumberInfo {
    private int value;
}
public class StreamCollectionDemo {
    /*
        The collect() operation is a powerful and versatile terminal operation in Java Streams that
        allows you to accumulate the elements of a stream into a result container.
        It's like saying, "Take all the processed items in this stream and put them into a specific structure."

        The collect() method takes a single argument: a Collector.
        The Collector interface defines how the elements of a stream should be accumulated.
        Java provides a rich set of built-in Collector implementations in the java.util.stream.Collectors class, covering many common use cases.
    */
    public static void main(String[] args) {
        //1. Collectors.toList(): Accumulates stream elements into a new List.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> nameList = names.stream().collect(Collectors.toList());
        System.out.println("List of names: " + nameList); // Output: List of names: [Alice, Bob, Charlie]


        //2. Collectors.toSet(): Accumulates stream elements into a new Set, automatically removing duplicates.
        List<String> colors = Arrays.asList("red", "green", "blue", "red");
        Set<String> colorSet = colors.stream().collect(Collectors.toSet());
        System.out.println("Set of colors: " + colorSet); // Output: Set of colors: [red, green, blue]


        //3. Collectors.toMap(keyMapper, valueMapper): Accumulates stream elements into a new Map. It requires two functions: one to determine the key for each element (keyMapper) and another to determine the value (valueMapper).
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Map name to age
        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("Name to Age Map: " + nameToAgeMap); // Output: Name to Age Map: {Alice=30, Bob=25, Charlie=35}

        // Map age to name (handling potential duplicate keys by keeping the first one)
        Map<Integer, String> ageToNameMap = people.stream()
                .collect(Collectors.toMap(Person::getAge, Person::getName, (oldValue, newValue) -> oldValue));
        System.out.println("Age to Name Map: " + ageToNameMap); // Output: Age to Name Map: {30=Alice, 25=Bob, 35=Charlie}



        //4, 4. Collectors.joining(delimiter, prefix, suffix): Concatenates the stream elements into a single String, with optional delimiter, prefix, and suffix.
        List<String> fruits = Arrays.asList("apple", "banana", "orange");
        String joinedFruits = fruits.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined fruits: " + joinedFruits); // Output: Joined fruits: [apple, banana, orange]



        //5. Collectors.groupingBy(classifier): Groups the stream elements based on a classification function and collects the results into a Map where the keys are the classification results and the values are Lists of elements belonging to that group.
        List<Book> books = Arrays.asList(
                new Book("The Lord of the Rings", "Fantasy"),
                new Book("Pride and Prejudice", "Romance"),
                new Book("The Hobbit", "Fantasy"),
                new Book("Emma", "Romance"),
                new Book("Foundation", "Science Fiction")
        );

        Map<String, List<Book>> booksByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
        System.out.println("Books by Genre: " + booksByGenre);
        // Output: Books by Genre: {Fantasy=[Book(title=The Lord of the Rings, genre=Fantasy), Book(title=The Hobbit, genre=Fantasy)], Romance=[Book(title=Pride and Prejudice, genre=Romance), Book(title=Emma, genre=Romance)], Science Fiction=[Book(title=Foundation, genre=Science Fiction)]}




        //6. Collectors.partitioningBy(predicate): Partitions the stream elements into two groups based on a boolean predicate. The result is a Map with two keys: true (for elements that satisfy the predicate) and false (for elements that don't). The values are Lists of the corresponding elements.
        List<NumberInfo> numbers = Arrays.asList(
                new NumberInfo(10),
                new NumberInfo(5),
                new NumberInfo(12),
                new NumberInfo(7),
                new NumberInfo(9)
        );

        Map<Boolean, List<NumberInfo>> evenOddNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n.getValue() % 2 == 0));
        System.out.println("Even and Odd Numbers: " + evenOddNumbers);
        // Output: Even and Odd Numbers: {false=[NumberInfo(value=5), NumberInfo(value=7), NumberInfo(value=9)], true=[NumberInfo(value=10), NumberInfo(value=12)]}

    }
}
