package ru.yandex.dimas224;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Expression {
  private final String numberOne;
  private final String numberTwo;
  private final String operation;

  private static final Map<String, Integer> ROMAN_NUMBERS = new HashMap<>();
  private static final Set<String> OPERATIONS = new HashSet<>();

  private static final String WRONG_INPUT = "Wrong input data";
  private static final String WRONG_RESULT = "Result is 0 or below";

  static {
    ROMAN_NUMBERS.put("I", 1);
    ROMAN_NUMBERS.put("II", 2);
    ROMAN_NUMBERS.put("III", 3);
    ROMAN_NUMBERS.put("IV", 4);
    ROMAN_NUMBERS.put("V", 5);
    ROMAN_NUMBERS.put("VI", 6);
    ROMAN_NUMBERS.put("VII", 7);
    ROMAN_NUMBERS.put("VIII", 8);
    ROMAN_NUMBERS.put("IX", 9);
    ROMAN_NUMBERS.put("X", 10);

    OPERATIONS.add("+");
    OPERATIONS.add("-");
    OPERATIONS.add("/");
    OPERATIONS.add("*");
  }

  public Expression(String input) {
      if (isValid(input)) {
        String[] components = input.split(" ");
        this.numberOne = components[0];
        this.operation = components[1];
        this.numberTwo = components[2];
      } else {
        throw new NumberFormatException(WRONG_INPUT);
      }
  }

  private boolean isValid(String input) {
    if (input == null) {
      return false;
    }

    String[] components = input.split(" ");

    if (components.length != 3) {
      return false;
    }

    if (!OPERATIONS.contains(components[1])) {
      return false;
    }

    if (!isRomanNumbers(components[0], components[2]) && !isArabianNumbers(components[0], components[2])) {
      return false;
    }

    return true;
  }

  private boolean isArabianNumbers(String numberOne, String numberTwo) {
    try {
      return ROMAN_NUMBERS.containsValue(Integer.parseInt(numberOne))
              && ROMAN_NUMBERS.containsValue(Integer.parseInt(numberTwo));
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean isRomanNumbers(String numberOne, String numberTwo) {
    return ROMAN_NUMBERS.containsKey(numberOne) && ROMAN_NUMBERS.containsKey(numberTwo);
  }

  private Calculator getCalculator() {
    return new Calculator();
  }

  public String calculate() {
    int result;

    if (isArabianNumbers(numberOne, numberTwo)) {
      result = getCalculator().calculate(Integer.parseInt(numberOne), operation, Integer.parseInt(numberTwo));
    } else {
      result = getCalculator().calculate(ROMAN_NUMBERS.get(numberOne), operation, ROMAN_NUMBERS.get(numberTwo));
      if (result > 0) {
        return IntegerToRomanConverter.convert(result);
      } else {
        throw new NumberFormatException(WRONG_RESULT);
      }
    }
    return String.valueOf(result);
  }
}
