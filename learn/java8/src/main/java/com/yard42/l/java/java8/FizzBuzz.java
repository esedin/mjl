package com.yard42.l.java.java8;

import java.util.Optional;

public class FizzBuzz
{
   public static String fizzBuzz(int number)
   {
      String result = Optional.of(number).map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "")).get();

      return result.isEmpty() ? Integer.toString(number) : result;
   }
}
