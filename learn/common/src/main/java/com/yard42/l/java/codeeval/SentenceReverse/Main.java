/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.SentenceReverse;

import java.io.*;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      String out = "";
      while ((line = buffer.readLine()) != null)
      {
         line = line.trim();
         if (line.length() == 0) continue;

         char[] charStr = line.toCharArray();
         revert(charStr);
         String reverted = String.valueOf(charStr);
         for (String word : reverted.split(" "))
         {
            char[] chrWord = word.toCharArray();
            revert(chrWord);
            out += String.valueOf(chrWord) + " ";
         }
         System.out.println(out.trim());
         out = "";
      }
   }

   private static void swap(char[] chrString, int pos1, int pos2)
   {
      char tmp = chrString[pos1];
      chrString[pos1] = chrString[pos2];
      chrString[pos2] = tmp;
   }

   private static void revert(char[] chrs)
   {
      for (int i = 0; i < chrs.length / 2; i++)
      {
         swap(chrs, i, chrs.length - i - 1);
      }
   }
}
