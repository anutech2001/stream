package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
  public static void main(String[] args) {

    // Example 1
    Stream.of(1, 2, 3)
        // map the elements of the input stream to streams, and then flatten the mapped
        // streams.
        .flatMap(n -> Stream.of(n, n * n)).forEach(System.out::print);

    // Example 2
    List<Integer> num1 = List.of(1, 4, 2, 5, 7, 6);
    List<Integer> num2 = List.of(1, 8, 3, 2, 9, 0, 4);
    Stream<List<Integer>> list = Stream.of(num1, num2);

    List<Integer> result = list.flatMap(x -> x.stream()).collect(Collectors.toList());
    System.out.println(result);
    // demo distinct(), sorted()

    // Example 3
    List<String> words = Arrays.asList("Java Stream Api", "Java Lambda");
    List<String> transformedWord = words.stream() // Stream<String>
        .map(s -> s.split("")) // Stream<String[]
        .flatMap(Arrays::stream) //
        .distinct().collect(Collectors.toList());
    System.out.println(transformedWord);
  }
}
