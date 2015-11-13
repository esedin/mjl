package com.yard42.l.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

public class Lambdas
{
   public static void main(String[] args)
   {
      Function<Integer, Integer> func = x -> x * 2;
      System.out.println(func.apply(10));

      //Supplier
      display(() -> 210);

      //Predicate
      ArrayList<String> animals = new ArrayList<>();
      animals.add("cat");
      animals.add("dog");
      animals.add("cheetah");
      animals.add("deer");

      animals.removeIf(element -> element.startsWith("c"));
      System.out.println(animals.toString());

      //Consumer
      Consumer<Integer> consumer = x -> display(x-1);
      consumer.accept(2);
      consumer.accept(7);

      //UnaryOperator
      UnaryOperator<Integer> operator = v -> v * 100;
      Function<Integer, Integer> function = v -> v * 100;

      System.out.println(operator.apply(4));
      System.out.println(function.apply(4));

      //BiConsumer
      HashMap<String, String> hash = new HashMap<>();
      hash.put("cat", "orange");
      hash.put("dog", "black");
      hash.put("snake", "green");
      hash.forEach((string1, string2) -> System.out.println(string1 + "..." + string2 + ", " + string1.length()));
   }

   static void display(int value) {
      switch (value) {
         case 1:
            System.out.println("There is 1 value");
            return;
         default:
            System.out.println("There are " + Integer.toString(value)
               + " values");
            return;
      }
   }

   static void display(Supplier<Integer> arg){
      System.out.println(arg.get());
   }
}
