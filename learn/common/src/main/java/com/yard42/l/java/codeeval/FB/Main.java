package com.yard42.l.java.codeeval.FB;

import java.io.*;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      final String filename = args[0];

      String line;
      BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
      while ((line = bufferedReader.readLine()) != null)
      {
         fizzBuzz(line.split(" "));
      }
   }

   private static void fizzBuzz(String[] parts)
   {
      Integer x = Integer.parseInt(parts[0]);
      Integer y = Integer.parseInt(parts[1]);
      Integer n = Integer.parseInt(parts[2]);

      String out = "";

      for (int i = 0; i++ < n; )
      {
         if (i % x == 0) out = "F";
         if (i % y == 0) out += "B";
         System.out.print(out.equals("") ? i : out);
         System.out.print(" ");
         out = "";
      }

      System.out.println("");
   }
}
