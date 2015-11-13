package com.yard42.l.java.codeeval.SumPrimes;

public class Main
{
   public static void main(String[] args)
   {
      int count = 0;
      int next = 1;
      int sum = 1;

      while (count < 1000)
      {
         if (isPrime(next))
         {
            sum += next;
            count++;
         }
         next++;
      }

      System.out.println(sum);
   }

   private static boolean isPrime(int num)
   {
      if (num % 2 == 0) return false;
      for (int i = 3; i * i <= num; i += 2) if (num % i == 0) return false;
      return true;
   }
}