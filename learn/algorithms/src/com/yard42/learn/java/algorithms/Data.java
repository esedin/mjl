package com.yard42.learn.java.algorithms;

public class Data
{
   public static int[] toSortArray = {3,5,7,1,4,2,9,10};

   public static int[] buildRandomArray(int size)
   {
      int[] newArray = new int[size];
      for(int i = 0; i < size; i++)
      {
         double rnd = Math.random();
         newArray[i] = new Double(rnd * 100).intValue();
      }

      return newArray;
   }

   public static void printArray(int[] array)
   {
      for (int i = 0; i<array.length; i++)
      {
         System.out.print(array[i] + " ");
      }
      System.out.println();
   }
}
