package com.yard42.l.java.codeeval.SubString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File("..\\s.in");
      //File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      while ((line = buffer.readLine()) != null)
      {
         line = line.trim();
         String[] pairs = line.split(",");

         String testString = pairs[0];
         String template = pairs[1];

         char[] templateChars = template.toCharArray();

         List<String> templateParts = new ArrayList<String>();
         String current = "";

         int i = 0;

         while (i < templateChars.length)
         {
            if (templateChars[i] == '\\' && templateChars[i + 1] != '*')
            {
               current += '*';
               i++;
            }

            if (templateChars[i] == '*')
            {
               templateParts.add(current);
               i++;
               current = "";
            }

            current += templateChars[i];
            i++;
         }

         templateParts.add(current);

         int prev = 0;

         for (String templatePart : templateParts)
         {
            int pos = testString.indexOf(templatePart);

            if (pos == -1)
            {
               System.out.println(false);
               break;
            }

            //if (pos < prev)
         }

         System.out.println(templateParts);
      }
   }
}