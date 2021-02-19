/** Orginal from https://mkyong.com/java8/java-8-parallel-streams-examples/ */
package com.example.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelFileExample {

  private static final String DIR = System.getProperty("user.home") + "/fileparallel/";

  public static void main(String[] args) throws IOException {

    Files.createDirectories(Paths.get(DIR));

    ParallelFileExample obj = new ParallelFileExample();

    List<Employee> employees = obj.generateEmployee(10000);

    Instant start = Instant.now();

    employees.stream().parallel().forEach(ParallelFileExample::save); // 7s-8s
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    System.out.printf("\nUsage Time: %s%n", timeElapsed);
  }

  private static void save(Employee input) {

    try (FileOutputStream fos = new FileOutputStream(new File(DIR + input.getName() + ".ser"));
        ObjectOutputStream obs = new ObjectOutputStream(fos)) {
      obs.writeObject(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private List<Employee> generateEmployee(int num) {

    return Stream.iterate(0, n -> n + 1).limit(num).map(x -> {
      return new Employee(generateRandomName(4), generateRandomAge(15, 100), generateRandomSalary(900.00, 200_000.00));
    }).collect(Collectors.toList());
  }

  private String generateRandomName(int length) {
    return new Random().ints(5, 97, 122) // 97 = a , 122 = z
        .mapToObj(x -> String.valueOf((char) x)).collect(Collectors.joining());
  }

  private int generateRandomAge(int min, int max) {
    return new Random().ints(1, min, max).findFirst().getAsInt();
  }

  private BigDecimal generateRandomSalary(double min, double max) {
    return new BigDecimal(new Random().doubles(1, min, max).findFirst().getAsDouble()).setScale(2,
        RoundingMode.HALF_UP);
  }
}
