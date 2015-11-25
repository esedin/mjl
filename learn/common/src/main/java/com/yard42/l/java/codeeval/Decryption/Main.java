/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.Decryption;

public class Main
{
   public static void main(String[] args)
   {
      final String keys = "BHISOECRTMGWYVALUZDNFJKPQX";
      final char[] message = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119".toCharArray();

      String output = "";
      String curr = "";

      for (char msgChar : message)
      {
         if (msgChar == ' ')
         {
            output += " ";
         }
         else
         {
            if (curr.length() == 0) curr += msgChar;
            else
            {

               output += (char)('A' + keys.indexOf('A' + parseInt(curr + msgChar)));
               curr = "";
            }
         }
      }

      System.out.println(output);
   }

   public static int parseInt(final String s)
   {
      final int len = s.length();
      final char ch = s.charAt(0);
      int num = ch - '0';

      int i = 1;
      while (i < len)
         num = num * 10 + (s.charAt(i++) - '0');

      return num;
   }
}
