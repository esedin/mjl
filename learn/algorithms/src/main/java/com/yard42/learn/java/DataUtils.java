package com.yard42.learn.java;

import com.yard42.learn.java.graph.TreeNode;

public class DataUtils
{
   private static int counter = 0;

   public static int[] buildRandomArray(int size)
   {
      int[] newArray = new int[size];
      for (int i = 0; i < size; i++)
      {
         double rnd = Math.random();
         newArray[i] = new Double(rnd * 100).intValue();
      }

      return newArray;
   }

   public static void printArray(int[] array)
   {
      for (int anArray : array)
      {
         System.out.print(anArray + " ");
      }

      System.out.println();
   }

   public static TreeNode buildRandomTree(int depth, int maxLeaves, boolean newTree)
   {
      if (newTree)
      {
         counter = 0;
      }

      TreeNode root = new TreeNode(++counter);

      if (depth != 1)
      {
         for (int i = maxLeaves; i > 0; i--)
         {
            root.addNode(buildRandomTree(depth - 1, maxLeaves, false));
         }
      }

      return root;
   }
}
