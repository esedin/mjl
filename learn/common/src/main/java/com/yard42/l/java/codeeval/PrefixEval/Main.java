/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.codeeval.PrefixEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      Stack<Float> operands = new Stack<Float>();

      while ((line = buffer.readLine()) != null)
      {
         if (line.trim().length() == 0) continue;

         String[] parts = line.split(" ");

         for (int i = parts.length - 1; i >=0; i--)
         {
            String part = parts[i];

            if (part.equals("*")||part.equals("/")||part.equals("+"))
            {
               Float operand1 = operands.pop();
               Float operand2 = operands.pop();
               switch (part)
               {
                  case "*" : operands.push(operand1 * operand2); break;
                  case "/" : operands.push(operand1 / operand2); break;
                  case "+" : operands.push(operand1 + operand2); break;
               }
            }
            else {
               operands.push(new Float(part));
            }
         }

         System.out.println(operands.pop());
      }
   }
}
