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
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(intStream.mapToInt(x -> x).sum()); // 15

        //// Compute an average
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        OptionalDouble avg = intStream1.average();
        System.out.println(avg.getAsDouble()); // 3.0

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream2 = objStream.mapToInt(s -> s.length());

        threeDigit(Optional.empty());
        threeDigit(Optional.of(433));
        var ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333

    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }
}