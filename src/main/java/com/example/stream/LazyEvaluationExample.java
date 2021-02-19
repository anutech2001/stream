package com.example.stream;

import java.util.stream.Stream;

/** LazyEvaluationExample */
public class LazyEvaluationExample {

  public static void main(String[] args) {
    Stream.generate(Math::random).forEach(System.out::println);
  }
}
