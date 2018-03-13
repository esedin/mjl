package com.yard42.l.java.java8;

import java.util.Arrays;

public class ParallelStreams
{
   public static void main(String[] args)
   {
      Double[] unsorted = new Double[10000000];
      for (int i = 0; i < unsorted.length; i++)
      {
         unsorted[i] = random(i, unsorted.length);
      }

      long start = System.currentTimeMillis();
      Arrays.sort(unsorted);
      long end = System.currentTimeMillis();

      System.out.println("time: " + (end - start) + " ms.");

      start = System.currentTimeMillis();
      Arrays.parallelSort(unsorted);
      end = System.currentTimeMillis();

      System.out.println("time: " + (end - start) + " ms.");
   }

   private static Double random(int i, int length)
   {
      return Math.random() * i % length;
   }
}
