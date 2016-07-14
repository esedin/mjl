package com.yard42.learn.java.algorithms;

import static com.yard42.learn.java.algorithms.Data.*;

public class Insertion
{
   public static void main(String[] args)
   {
      int j = 0;

      int[] toSortArray = Data.buildRandomArray(10);
      Data.printArray(toSortArray);

      for (int i = 1; i < toSortArray.length; i++)
      {
         int current = toSortArray[i];
         j = i - 1;

         while (j >= 0 && toSortArray[j] > current)
         {
            toSortArray[j + 1] = toSortArray[j];
            j = j - 1;
         }

         toSortArray[j + 1] = current;
      }

      Data.printArray(toSortArray);
   }
}
