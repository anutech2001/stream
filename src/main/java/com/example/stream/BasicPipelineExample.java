package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicPipelineExample {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("anurak", "somchai", "ekachai", "som", "bird", "padthai");
    String result =
        list.stream()
            .filter(x -> x.length() >= 6)
            .map(x -> x.toUpperCase())
            .collect(Collectors.joining("\n"));
    System.out.println(result);
  }

  // demo: see insert print x in filter and delete terminal operation then try it.
}
