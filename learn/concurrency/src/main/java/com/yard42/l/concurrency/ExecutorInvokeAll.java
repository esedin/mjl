package com.yard42.l.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorInvokeAll
{
   public void runApp() throws InterruptedException, ExecutionException
   {
      AtomicInteger sum = new AtomicInteger();

      ExecutorService executorService = Executors.newFixedThreadPool(10);

      List<Callable<AtomicInteger>> callableList = new ArrayList<>();

      for (int count = 0; count <= 100; count++)
      {
         callableList.add(getInstanceOfCallable(count, sum));
      }

      List<Future<AtomicInteger>> resultFuture = executorService.invokeAll(callableList);

      for (Future<AtomicInteger> future : resultFuture)
      {
         System.out.println("Status of future : " + future.isDone() + ". Result of future : " + future.get().get());
      }

      executorService.shutdown();

      System.out.println("Final Sum : " + sum);
   }

   private Callable<AtomicInteger> getInstanceOfCallable(final int count, final AtomicInteger sum)
   {
      Callable<AtomicInteger> clientPlanCall = () -> {
         sum.addAndGet(count);
         System.out.println("Intermediate sum :" + sum);
         return sum;
      };

      return clientPlanCall;
   }

   public static void main(String[] args) throws ExecutionException
   {
      try
      {
         new ExecutorInvokeAll().runApp();
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
