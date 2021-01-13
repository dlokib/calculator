package com.example.calculator.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class RomanNumbers {
  public enum Number {
    C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private final int weight;

    private Number(int weight) {
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }

    public static Number getLargest(int weight) {
      return Arrays.stream(values())
        .filter(number -> weight >= number.weight)
        .findFirst().orElse(I);
    }
  }

  public static String toRoman(int number) {
    return IntStream.iterate(number, i -> i - Number.getLargest(i).getWeight())
      .limit(Number.values().length).filter(i -> i > 0)
      .mapToObj(Number::getLargest).map(String::valueOf)
      .collect(Collectors.joining());
  }

  public static int toArabic(String number) {
    String roman = number.toUpperCase();

    int result = new StringBuilder(roman).reverse().chars()
      .mapToObj(symbol -> Character.toString((char) symbol))
      .map(weight -> Enum.valueOf(Number.class, weight))
      .mapToInt(value -> value.getWeight())
      .reduce(0, (x, y) -> x + (x <= y ? y : -y));

    if(roman.length() > 2 && roman.charAt(0) == roman.charAt(1)) {
      result += 2 * Enum.valueOf(Number.class, roman.substring(0, 1)).weight;
    }

    return result;
  }
}
