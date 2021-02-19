package com.example.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** intermediateOpExample */
public class IntermediateOpExample {

  public static void main(String[] args) {

    // fillter()
    System.out.println("\n--- fillter() ---");
    Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
    s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

    // distinct()
    System.out.println("\n--- distinct() ---");
    Stream<String> s1 = Stream.of("duck", "duck", "duck", "goose");
    s1.distinct().forEach(System.out::print); // duckgoose

    // skit() and limit()
    System.out.println("\n--- skit() and limit() ---");
    Stream<Integer> s2 = Stream.iterate(1, n -> n + 1);
    s2.skip(5).limit(2).forEach(System.out::print); // 67

    // sort()
    System.out.println("\n--- sort() ---");
    Stream<String> sort = Stream.of("zoo-", "ant-", "boy-");
    sort.sorted().forEach(System.out::print);
    //// sort with Comparator
    System.out.println("\n");
    Stream<String> sortC = Stream.of("zoo-", "ant-", "boy-");
    sortC.sorted(Comparator.reverseOrder()).forEach(System.out::print);

    // map()
    System.out.println("\n--- map() ---");
    Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
    s3.map(String::length).forEach(System.out::print);

    Stream.of(1, 2, 3).map(n -> n * n).forEach(System.out::println);

    // flatMap()
    System.out.println("\n--- flatMap() ---");
    List<String> empty = List.of();
    var name1 = List.of("anurak", "somchai");
    var name2 = List.of("somporn", "pim");
    var number =
        Stream.generate(() -> String.valueOf(Math.random())).limit(10).collect(Collectors.toList());
    Stream<List<String>> names = Stream.of(empty, name1, name2, number);
    names.flatMap(m -> m.stream()).forEach(System.out::println);

    // peek()
    System.out.println("\n--- peek() ---");
    Stream<String> peekStream = Stream.of("zoo-", "ant-", "boy-");
    peekStream.peek(System.out::println).sorted().forEach(System.out::print);
    // peek() be careful
    var numbers = new ArrayList<Integer>();
    var letters = new ArrayList<String>();
    numbers.add(1);
    letters.add("a");
    Stream<List<?>> bad = Stream.of(numbers, letters);
    bad.peek(x -> x.remove(0)).map(List::size).forEach(System.out::print);
  }
}
