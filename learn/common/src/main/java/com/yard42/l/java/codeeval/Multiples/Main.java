/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.Multiples;

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
         String parts[] = line.split(",");
         Integer x = Integer.valueOf(parts[0]);
         Integer n = Integer.valueOf(parts[1]);
         if (x == n)
         {
            System.out.println(x);
            continue;
         }
         long tmp = n;
         while (true)
         {
            if (tmp < x)
            {
               tmp += n;
            }
            else break;
         }
         System.out.println(tmp);
      }
   }
}
