package com.yard42.l.java.java8;

import java.util.concurrent.atomic.DoubleAccumulator;

public class ConcurrentAtomic
{
   public static void main(String[] args)
   {
      double identity = 1.0;

      DoubleAccumulator doubleAccumulator = new DoubleAccumulator((x, y) -> x + y, identity);

      doubleAccumulator.accumulate(45.4);

      System.out.println("get " + doubleAccumulator.get());
      System.out.println("get then reset " + doubleAccumulator.getThenReset());
      System.out.println("get " + doubleAccumulator.get());


      doubleAccumulator.accumulate(3.0);
      doubleAccumulator.reset();
      System.out.println("get " + doubleAccumulator.get());
   }
}
