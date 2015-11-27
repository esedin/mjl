/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.SortArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
         if (line.trim().length() == 0) continue;
         String[] parts = line.split("\\|");

         String[] toSort = new String[parts.length];
         char[][] matrix = new char[parts.length][parts.length];
         int r = 0;

         for (String part : parts)
         {
            String[] cells = part.split(" ");

            int c = 0;

            for (String cell : cells)
            {
               if (cell.equals("")) continue;
               int intCell = Integer.valueOf(cell);
               char sym = (char) (150 + intCell);
               matrix[c][r] = sym;
               c++;
            }
            r++;
         }

         for ( int c = 0 ; c < toSort.length ; c++ )
         {
            toSort[c] = String.copyValueOf(matrix[c]);
         }

         Arrays.sort(toSort);

         for ( int c = 0 ; c < toSort.length ; c++ )
         {
            matrix[c] = toSort[c].toCharArray();
         }

         for ( int c = 0 ; c < toSort.length ; c++ )
         {
            for ( int d = 0 ; d < toSort.length ; d++ )
               System.out.print(matrix[d][c] - 150 + " ");

            if (c != toSort.length - 1) System.out.print("| ");
         }

         System.out.println();
      }
   }
}
