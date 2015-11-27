/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.ExcelColumns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
   public static final char[] alplhabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

   public static void main(String[] args) throws IOException
   {
      File file = new File("c:\\s.in");
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;

      while ((line = buffer.readLine()) != null)
      {
         StringBuilder sb = new StringBuilder("");
         if (line.trim().length() == 0) continue;

         int in = Integer.parseInt(line);
         int ost, snos = 0;

         while (in > 0)
         {
            ost = in % 26;
            if (ost == 0)
            {
               ost = 26;
               snos++;
            }
            else
            {
               snos = 0;
            }

            sb.append(alplhabet[ost - 1]);
            in = in / 26 - snos;
         }

         System.out.println(sb.reverse().toString());
      }
   }
}
