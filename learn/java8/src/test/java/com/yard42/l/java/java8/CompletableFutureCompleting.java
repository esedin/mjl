package com.yard42.l.java.java8;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class CompletableFutureCompleting
{
   @Test
   public void forceCompletingTest() throws ExecutionException, InterruptedException
   {
      CompletableFuture<Integer> completableFutureToBeCompleted = CompletableFuture.supplyAsync(() -> {
         TestUtils.sleep(1000);
         return 10;
      });

      CompletableFuture<Integer> completor = CompletableFuture.supplyAsync(() -> {
         completableFutureToBeCompleted.complete(20);
         return 10;
      });

      assertEquals(completor.get().intValue(), 10);
      assertEquals(completableFutureToBeCompleted.get().intValue(), 20);
   }
}
