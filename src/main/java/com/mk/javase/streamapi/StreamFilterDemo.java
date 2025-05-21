package com.mk.javase.streamapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
    Collection Stream - >sequence of Object, Array or Collection
    Filter -> loop if
    Reduce -> loop -> pairwise -> Single item
    Map -> travel each item -> transform
    the beginning of java, not create for multi core processor architecture , in thread we understand the power of multi core processor
    that can working in multi core processor architecture is call Stream
    use Stream api -> compute concurrent behind the scenes present -> can't use plain use with Functional Programming
    ArrayList -> size not fix can decrease or increase it
    Array -> fixed size can't decrease or increase it
 */
public class StreamFilterDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(2);
        list.add(28);
        list.add(6);
        list.add(9);
        list.add(13);
        list.add(11);
        //change list to stream -> get Stream and can compute on that Steam
        Stream<Integer> integerStream = list.stream();
        /*
            1 - 1000 -> can split 1000 per 10 item compute in multi core processor
            find min max
            Why FP can't do in original collection because want to give backward compatibility so launch Stream concept
            Stream can do only one time -> run with tape logic -> run start to end is ended -> one direction flow -> Immutable -> want us to create new Data Structure
                -> in Thread face with Synchronized problem -> all thread compute one data -> concurrency issue
                -> Stream do parallel -> not to use share stream with other so clone stream to use -> use copy for each
                -> Because FP not to use the same, parallel -> if use not become pure function
            why not use Collection directly because use Stream is faster than collection in multi core processor
         */
        Optional<Integer> min = integerStream.min(Integer::compare);
        System.out.println("Min : "+ min.get());

        integerStream = list.stream(); // need to create new Stream
        Optional<Integer> max = integerStream.max(Integer::compare);
        System.out.println("Max : "+ max.get());

        Stream<Integer> sortedSteam = list.stream().sorted();
        sortedSteam.forEach(System.out::println);

        System.out.println("------ > 10-------");
        /*
            we can use FP in Stream
            Filter -> want item that > 10 in arrayList -> accept predicate return boolean
         */
        Stream<Integer> filterStream = list
                .stream()
                .filter(n -> n >= 10);// need predicate
        filterStream.forEach(System.out::println);

        System.out.println("------Even-------");
        Stream<Integer> filterEvenStream = list
                .stream()
                .sorted() // chain -> do Stream operation fist and then sorted
                .filter(n -> n %2 ==0);// need predicate
        filterEvenStream.forEach(System.out::println);

        System.out.println("------ > 10 Even-------");
        Predicate<Integer> isEven = n -> n % 2 ==0;
        Stream<Integer> greaterEvenStream = list
                .stream()
                .sorted()
                .filter(n -> n >= 10)
                .filter(isEven);
        greaterEvenStream.forEach(System.out::println);

        System.out.println("------ > 10 Odd-------");
        Stream<Integer> greaterOddStream = list
                .stream()
                .sorted()
                .filter(n -> n >= 10)
                .filter(n -> n%2 ==1);
        greaterOddStream.forEach(System.out::println);

        // Iterator
        Iterator<Integer> iterator = list.stream().iterator();
        while(iterator.hasNext()){
            System.out.println("Iterator : "+ iterator.next());
        }

        //Spliterator -> spilt to computer good for concurrent // may or may not be give order guarantee
        Spliterator<Integer> spliterator = list.spliterator();
        while (spliterator.tryAdvance(n-> System.out.println(n)));
    }

}
