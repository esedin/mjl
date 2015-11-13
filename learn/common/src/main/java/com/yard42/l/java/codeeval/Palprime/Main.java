/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.Palprime;

public class Main
{
   public static void main(String[] args)
   {
      for (int num = 1000; num-- > 2; )
      {
         if (!isPalindrom(num)) continue;
         if (!isPrime(num)) continue;
         System.out.println(num);
         break;
      }
   }

   private static boolean isPrime(int num)
   {
      if (num % 2 == 0) return false;
      for (int i = 3; i * i <= num; i += 2)
      {
         if (num % i == 0)
            return false;
      }
      return true;
   }

   private static boolean isPalindrom(int num)
   {
      String number = String.valueOf(num);
      Integer len = number.length();
      for (int i = 0; i < len / 2; i++)
      {
         if (number.charAt(i) != number.charAt(len - i - 1)) return false;
      }
      return true;
   }
}
