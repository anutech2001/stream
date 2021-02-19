package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamExample {
  public static void main(String[] args) {

    // Example 1: Creating Infinite Streams
    Stream<Double> randoms = Stream.generate(Math::random);
    // randoms.forEach(System.out::println);
    Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    // oddNumbers.forEach(System.out::println);
    // oddNumbers.count(); // demo with parallel stream

    // Example 2: Creating Finite Streams
    //// Case 1: create single stream
    Stream<String> singleStream = Stream.of("Hello");
    System.out.print("Single Stream: ");
    singleStream.forEach(System.out::println);

    //// Case 2: create array stream
    Stream<String> arrayStream = Stream.of("Hello", "world"); // varargs
    System.out.print("Array Stream: ");
    arrayStream.forEach(System.out::println);

    //// Case 3: create empty stream
    Stream<String> emptyStream = Stream.empty();
    System.out.print("Empty Stream: ");
    emptyStream.forEach(System.out::println);

    //// Case 4: create from Collection
    List<String> list = Arrays.asList("anurak", "somchai", "ekachai", "som", "bird", "padthai");
    Stream<String> nameStream = list.stream();

    //// Case 5: create from infinite stream
    //// jdk 1.9 required for this overloaded
    Stream<Integer> oddNumbersLimitStream = Stream.iterate(1, n -> n < 100, n -> n + 2);
    // oddNumbersLimitStream.forEach(System.out::println);

    //// Create Parallel Stream
    List<String> listForParallel =
        Arrays.asList("anurak", "somchai", "ekachai", "som", "bird", "padthai");
    Stream<String> parallelStream = listForParallel.parallelStream();
    System.out.print("Parallel Stream: ");
    parallelStream.forEach(System.out::println);
  }
}
