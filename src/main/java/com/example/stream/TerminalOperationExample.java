package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** TerminalOperationExample */
public class TerminalOperationExample {

  public static void main(String[] args) {

    // count()
    Stream<String> f = Stream.of("anurak", "somchai", "ekachai");
    System.out.println(f.count());

    // min()
    Stream<String> firstName = Stream.of("anurak", "somchai", "pimnara");
    Optional<String> min = firstName.min((s1, s2) -> s1.length() - s2.length());
    min.ifPresent(System.out::println);

    // max()
    Stream<String> maxf = Stream.of("anurak", "somchai", "pimnara1");
    Optional<String> max = maxf.min((s1, s2) -> s2.length() - s1.length());
    max.ifPresent(System.out::println);

    // findAny()
    Stream<String> findA = Stream.of("anurak", "somchai", "pimnara1");
    findA.findAny().ifPresent(System.out::println);

    // anyMatch(), allMatch() and noneMatch()
    Stream<String> match = Stream.of("anurak", "somchai", "1pimnara");
    System.out.println(match.anyMatch(x -> Character.isDigit(x.charAt(0))));
    // System.out.println(match.noneMatch(x -> x.equals("anurak1")));
    // System.out.println(match.allMatch(x -> x.equals("anurak")));

    // forEach()
    Stream<String> forS = Stream.of("anurak", "somchai", "pimnara");
    forS.forEach(System.out::println);
    // if we try to use for-loop, try it.

    // reduce()
    Stream<String> reduceS = Stream.of("anurak", "somchai", "pimnara");
    System.out.println(reduceS.reduce((s1, s2) -> s1 + "," + s2));
    Stream<Integer> numS = Stream.of(5, 5, 5, 5, 5);
    System.out.println(numS.reduce(0, (x, y) -> x + y));

    // collect() - stream to List
    Stream<String> collectS = Stream.of("anurak", "somchai", "pimnara");
    List<String> list = collectS.collect(Collectors.toList());
    System.out.println("Stream to List = " + list);

    // collect() - stream to List
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
    Map<Integer, Set<String>> result =
        givenList.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    System.out.println("Stream to Map = " + result);

    // Infinite streams terminates
    Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 1);
    // oddNumbers.findAny().ifPresent(System.out::println);
    // oddNumbers.forEach(System.out::println);
    // System.out.println(oddNumbers.reduce(0, (x, y) -> x + y));

  }
}
