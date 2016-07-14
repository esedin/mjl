package com.yard42.learn.java.algorithms;

import static com.yard42.learn.java.algorithms.Data.buildRandomArray;
import static com.yard42.learn.java.algorithms.Data.printArray;

public class Merge
{
   public static void main(String[] args)
   {
      int[] toSortArray = buildRandomArray(10);
      printArray(toSortArray);

      mergeSort(toSortArray, 1, toSortArray.length);

      printArray(toSortArray);
   }

   static void mergeSort(int[] array, int head, int tail)
   {
      if (head < tail)
      {
         int middle = (head + tail) / 2;
         mergeSort(array, head, middle);
         mergeSort(array, middle, tail);
         merge(array, head, middle, tail);
      }
   }

   private static void merge(int[] array, int head, int middle, int tail)
   {
      int pos1 = head;
      int pos2 = middle + 1;
      int pos3 = 0;

      int[] buffer = new int[tail - head + 1];

      while (pos1 < middle && pos2 < tail)
      {
         if (array[pos1] < array[pos2])
         {
            buffer[pos3++] = array[pos1++];
         }
         else
         {
            buffer[pos3++] = array[pos2++];
         }
      }

      while (pos2 <= tail) buffer[pos3++] = array[pos2++];
      while (pos1 <= middle) buffer[pos3++] = array[pos2++];

      for (int i = 0; i < buffer.length; i++)
      {
         array[head + i] = buffer[i];
      }
   }
}
