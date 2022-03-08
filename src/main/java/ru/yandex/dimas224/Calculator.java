package ru.yandex.dimas224;

import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] expression = scanner.nextLine().split(" ");
    System.out.println(expression.length);

  }
}
