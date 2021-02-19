package com.example.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamExample {
    public static void main(String[] args) {
        //
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream.reduce(0, (s, n) -> s + n)); // 15
        //// Using IntStream
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream2.mapToInt(x -> x).sum()); // 15

        //// Compute an average
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        OptionalDouble avg = intStream1.average();
        System.out.println(avg.getAsDouble()); // 3.0

        var ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333

    }

}