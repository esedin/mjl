/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.LCS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
   private static String a, b;

   private static int[][] sol;

   public static void main(String[] args) throws IOException
   {
      File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      while ((line = buffer.readLine()) != null)
      {
         if (line.trim().length() == 0) continue;
         String parts[] = line.split(";");
         a = parts[0];
         b = parts[1];

         sol = new int[a.length() + 1][];

         for (int i = 0; i < a.length() + 1; i++)
         {
            int[] row = new int[b.length() + 1];
            Arrays.fill(row, -1);
            sol[i] = row;
         }

         find_lcs(0, 0);

         System.out.println(getLCS().trim());
      }
   }

   private static String getLCS()
   {
      String lcs = "";

      for (int i = 0, j = 0; sol[i][j] != 0 && i < a.length() && j < b.length(); )
      {
         if (a.charAt(i) == b.charAt(j))
         {
            lcs += a.charAt(i);
            i++;
            j++;
         }
         else
         {
            if (sol[i][j] == sol[i + 1][j]) i++;
            else j++;
         }
      }

      return lcs;
   }

   private static int find_lcs(int m, int n)
   {
      if (sol[m][n] < 0)
      {
         if (m == a.length() || n == b.length()) sol[m][n] = 0;

         else if (a.charAt(m) == b.charAt(n))
         {
            sol[m][n] = 1 + find_lcs(m + 1, n + 1);
         }
         else
         {
            int l1 = find_lcs(m + 1, n);
            int l2 = find_lcs(m, n + 1);
            sol[m][n] = l1 > l2 ? l1 : l2;
         }
      }

      return sol[m][n];
   }
}
