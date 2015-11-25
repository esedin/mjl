package com.yard42.l.java.codeeval.lightsout;

import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      while ((line = buffer.readLine()) != null)
      {
         String[] parts = line.trim().split(" ");
         int ncol = Integer.parseInt(parts[0]);
         int nrow = Integer.parseInt(parts[1]);

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

         int freeCount = freeVariablesCount(base);

         if (freeCount == -1)
         {
            System.out.println(-1);
         }
         else
         {
            int presses = countPresses(base);

            if (freeCount != 0)
            {
               System.out.println(findShortestSolution(base, freeCount, presses));
            }
            else
            {
               System.out.println(countPresses(base));
            }
         }
      }
   }

   private static int findShortestSolution(int[][] base, int freeCount, int presses)
   {
      int[][] tmp = new int[freeCount][];
      int[] answer = new int[base.length];
      int shortest = presses;

      for (int col = base.length - freeCount; col < base.length; col++)
      {
         int[] rowArr = new int[base.length];
         for (int row = 0; row < base.length; row++)
         {
            rowArr[row] = base[row][col];
         }
         tmp[base.length - col - 1] = rowArr;
      }

      for (int i = 0; i < base.length; i++)
      {
         answer[i] = base[i][base.length];
      }

      for (int i = 0; i < tmp.length; i++)
      {
         int[] newAnswer = xor(tmp[i], answer);
//         System.out.println("Answer");
//         System.out.println(Arrays.toString(answer));
//         System.out.println("Row");
//         System.out.println(Arrays.toString(tmp[i]));

         newAnswer[tmp[i].length - freeCount + i] = 1;
         int count = countOnes(newAnswer) + 1;

         shortest = count < shortest ? count : shortest;

//         System.out.println("newAnswer");
//         System.out.println(Arrays.toString(newAnswer));

         for (int j = i + 1; j < tmp.length; j++)
         {
            count = countOnes(xor(tmp[j], newAnswer)) + 1;
            shortest = count < shortest ? count : shortest;
         }
      }

      return shortest;
   }

   private static int countPresses(int[][] base)
   {
      int count = 0;
      int size = base.length;

      for (int[] aBase : base)
      {
         count += aBase[size];
      }

      return count;
   }

   private static int countOnes(int[] answer)
   {
      int count = 0;

      for (int anAnswer : answer)
      {
         count += anAnswer;
      }

      return count;
   }

   private static int freeVariablesCount(int[][] base)
   {
      int count = 0;

      for (int[] aBase : base)
      {
         int sum = 0;

         for (int j = 0; j < base.length; j++)
         {
            sum += aBase[j];
         }

         if (sum == 0)
         {
            if (aBase[base.length] == 1) return -1;
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