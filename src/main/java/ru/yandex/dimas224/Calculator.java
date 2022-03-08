package ru.yandex.dimas224;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
  private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

  static {
    OPERATIONS.put("+", (a, b) -> a + b);
    OPERATIONS.put("-", (a, b) -> a - b);
    OPERATIONS.put("/", (a, b) -> a / b);
    OPERATIONS.put("*", (a, b) -> a * b);
  }

  public int calculate(int numberOne, String operation, int numberTwo) {
    return OPERATIONS.get(operation).apply(numberOne, numberTwo);
  }
}
