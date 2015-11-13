package com.yard42.l.java.codeeval.SortLines;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      File file = new File(args[0]);
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;

      line = buffer.readLine();
      int amount = Integer.valueOf(line);

      TreeSet<String> sortedByLengthSet = new TreeSet<>(new Comparator<String>()
      {
         @Override
         public int compare(String o1, String o2)
         {
            int len1 = o1.length();
            int len2 = o2.length();
            return len2 - len1;
         }
      });

      while ((line = buffer.readLine()) != null)
      {
         line = line.trim();
         if (sortedByLengthSet.size() != amount || sortedByLengthSet.last().length() < line.length())
         {
            sortedByLengthSet.add(line);
         }
         if(sortedByLengthSet.size()>amount) sortedByLengthSet.remove(sortedByLengthSet.last());
      }

      for (String outLine : sortedByLengthSet)
      {
         System.out.println(outLine);
      }
   }
}