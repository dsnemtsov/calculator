package ru.yandex.dimas224;

import java.util.TreeMap;

public class IntegerToRomanConverter {
  private static final TreeMap<Integer, String> treemap = new TreeMap<>();
  static {
    treemap.put(100, "C");
    treemap.put(90, "XC");
    treemap.put(50, "L");
    treemap.put(40, "XL");
    treemap.put(10, "X");
    treemap.put(9, "IX");
    treemap.put(5, "V");
    treemap.put(4, "IV");
    treemap.put(1, "I");
  }

  private IntegerToRomanConverter() {
  }

  public static String convert(int number) {
    int l = treemap.floorKey(number);
    if (number == l) {
      return treemap.get(number);
    }
    return treemap.get(l) + convert(number - l);
  }
}
