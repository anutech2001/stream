package com.example.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamExample2 {

  public static void main(String[] args) {
    Instant start = Instant.now();
    long count =
        Stream.iterate(0, n -> n + 1)
            .limit(600_000)
            // .parallel() // with this 9s, without this 26s
            .filter(ParallelStreamExample2::isPrime)
            .count();
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    String timeElapsedStr =
        timeElapsed.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase();

    System.out.printf("\nTotal: %d, Usage Time: %s%n", count, timeElapsedStr);
  }

  public static boolean isPrime(int number) {
    if (number <= 1) return false;
    return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
  }
}
