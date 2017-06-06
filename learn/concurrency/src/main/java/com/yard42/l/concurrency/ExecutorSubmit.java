package com.yard42.l.concurrency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorSubmit
{
   public void runApp() throws InterruptedException, ExecutionException
   {
      AtomicInteger sum = new AtomicInteger();

      ExecutorService executorService = Executors.newFixedThreadPool(10);

      Future<AtomicInteger> future = null;

      for (int count = 0; count <= 100; count++)
      {
         future = executorService.submit(getInstanceOfCallable(count, sum));

         try
         {
            System.out.println("Status of future : " + future.isDone() + ". Result of future : " + future.get(1000, TimeUnit.MILLISECONDS).get());
         }
         catch (TimeoutException e)
         {
            System.out.println("<IGNORE> Timeout exception for count : " + count);
         }
      }

      executorService.shutdown();

      if (executorService.awaitTermination(10, TimeUnit.SECONDS))
      {
         System.out.println("All threads done with their jobs");
      }

      System.out.println("Final Sum : " + sum);
   }

   private Callable<AtomicInteger> getInstanceOfCallable(final int count, final AtomicInteger sum)
   {
      Callable<AtomicInteger> clientPlanCall = () -> {
         sum.addAndGet(count);
         return sum;
      };

      return clientPlanCall;
   }

   public static void main(String[] args) throws ExecutionException
   {
      try
      {
         new ExecutorSubmit().runApp();
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
