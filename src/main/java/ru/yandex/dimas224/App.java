package ru.yandex.dimas224;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Expression expression = new Expression(scanner.nextLine());

    System.out.println(expression.calculate());
  }
}
