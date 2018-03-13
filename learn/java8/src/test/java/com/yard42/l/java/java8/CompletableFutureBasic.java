package com.yard42.l.java.java8;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

public class CompletableFutureBasic
{
   @Test
   public void completableFutureGetNow()
   {
      CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
         () -> {
            TestUtils.sleep(5000);
            return "Then";
         }
      );

      assertEquals(completableFuture.getNow("Now"), "Now");
   }

   @Test(expected = TimeoutException.class)
   public void completableFutureGetTimeout() throws TimeoutException, InterruptedException, ExecutionException
   {
      CompletableFuture completableFuture = CompletableFuture.supplyAsync(
         () -> {
            TestUtils.sleep(5000);
            return 100;
         }
      );

      completableFuture.get(3, TimeUnit.SECONDS);
   }

   @Test
   public void completableFutureGet() throws InterruptedException, ExecutionException
   {
      CompletableFuture completableFuture = CompletableFuture.supplyAsync(
         () -> {
            TestUtils.sleep(5000);
            return 100;
         }
      );

      assertEquals(100, completableFuture.get());
   }
}
