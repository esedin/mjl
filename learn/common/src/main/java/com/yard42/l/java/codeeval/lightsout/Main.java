package com.yard42.l.java.codeeval.lightsout;

import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File("c:\\s.in");
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      while ((line = buffer.readLine()) != null)
      {
         String[] parts = line.trim().split(" ");
         if (parts[0].equals("#")) continue;
         int ncol = Integer.parseInt(parts[0]);
         int nrow = Integer.parseInt(parts[1]);
         int size = ncol * nrow;

         int[] out = new int[nrow * ncol];

         Arrays.fill(out, 0);
         int i = 0;
         for (char symbol : parts[2].toCharArray())
         {
            if (symbol == 'O') out[i++] = 1;
            if (symbol == '.') i++;
         }

         int[][] base = prepareBase(ncol, nrow, out);

         diagonalize(base);
         printMatrix(base);
         int freeCount = freeVariablesCount(base);
         if (freeCount == -1) {
            System.out.println(-1);
         }
         else {
            if (freeCount == 0)
            {
               System.out.println(countPresses(base));
            }
            else
            {
               // int outs[][] = getAllSolutions()
            }
         }
      }
   }

   private static int countPresses(int[][] base)
   {
      int count = 0;
      int size = base.length;

      for (int i = 0; i < base.length; i++)
      {
         count+=base[i][size];
      }

      return count;
   }

   private static int freeVariablesCount(int[][] base)
   {
      int count = 0;

      for(int i = 0; i<base.length; i++)
      {
         int sum = 0;

         for (int j = 0; j < base.length; j++)
         {
            sum+=base[i][j];
         }

         if (sum == 0)
         {
            if (base[i][base.length] == 1) return -1;
            else
            {
               count++;
            }
         }
      }

      return count;
   }

   private static void diagonalize(int[][] base)
   {
      int size = base.length;

      for (int j = 0; j < size; j++)
      {
         if (base[j][j] == 0)
         {
            int nonZeroPos = searchNonZero(base, j);
            if (nonZeroPos == 0) continue;
            base[j] = xor(base[j], base[nonZeroPos]);
         }

         for (int i = j + 1; i < size; i++)
         {
            if (base[i][j] != 0)
            {
               base[i] = xor(base[i], base[j]);
            }
         }

         for (int i = j - 1; i >= 0; i--)
         {
            if (base[i][j] != 0)
            {
               base[i] = xor(base[i], base[j]);
            }
         }
      }
   }

   private static int searchNonZero(int[][] base, int j)
   {
      for (int i = j + 1; i < base.length; i++)
      {
         if (base[i][j] == 1)
         {
            return i;
         }
      }

      return 0;
   }

   private static int[] xor(int[] row1, int[] row2)
   {
      int[] out = new int[row1.length];

      for (int i = 0; i < row1.length; i++)
      {
         out[i] = row1[i] ^ row2[i];
      }

      return out;
   }

   public static void printMatrix(int[][] matrix)
   {
      for (int i = 0; i < matrix.length; i++)
      {
         System.out.println(Arrays.toString(matrix[i]));
      }
      System.out.println();
   }

   private static int[][] prepareBase(int nrow, int ncol, int[] out)
   {
      int size = nrow * ncol;
      int[][] base = new int[size][size + 1];

      for (int i = 0; i < size; i++)
      {
         base[i][i] = 1;
         if (i + ncol < size) base[i][i + ncol] = 1;
         if (i - ncol >= 0) base[i][i - ncol] = 1;
         if (i - 1 >= 0 && (i - 1) % ncol != (ncol - 1)) base[i][i - 1] = 1;
         if (i + 1 < size && (i + 1) % ncol != 0) base[i][i + 1] = 1;
         base[i][size] = out[i];
      }

      return base;
   }
}