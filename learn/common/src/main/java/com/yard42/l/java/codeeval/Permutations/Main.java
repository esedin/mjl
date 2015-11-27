/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.Permutations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File("c:\\s.in");
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;

      while ((line = buffer.readLine()) != null)
      {
         line = line.trim();
         if (line.length() == 0) continue;
         List<String> arr = new ArrayList<String>();

         char[] chars = line.toCharArray();
         Arrays.sort(chars);
         permutate("", new String(chars), arr);

         StringBuilder sb = new StringBuilder(arr.get(0));
         for (int i = 1; i < arr.size(); i++)
         {
            sb.append(",").append(arr.get(i));
         }

         System.out.println(sb.toString());
      }
   }

   private static void permutate(String prefix, String toPermutate, List<String> outPut) {
      int len = toPermutate.length();
      if (len == 0) outPut.add(prefix);
      else {
         for (int i = 0; i < len; i++)
         {
            String newPrefix = prefix + toPermutate.charAt(i);
            permutate(newPrefix, toPermutate.substring(0, i) + toPermutate.substring(i + 1, len), outPut);
         }
      }
   }
}
