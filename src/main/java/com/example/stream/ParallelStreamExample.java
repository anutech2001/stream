package com.example.stream;

import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamExample {
  public static void main(String[] args) {

    // Example 1: sequencial vs parallele
    System.out.print("Sequencial...");
    IntStream range = IntStream.rangeClosed(1, 10);
    range.forEach(System.out::print);

    System.out.print("\nParallel...");
    IntStream range2 = IntStream.rangeClosed(1, 10);
    range2.parallel().forEach(System.out::print); // results will print in random

  }
}
