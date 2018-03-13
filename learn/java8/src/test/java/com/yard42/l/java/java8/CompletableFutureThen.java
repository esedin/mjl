package com.yard42.l.java.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThen
{
   public static void main(String[] args) throws InterruptedException, ExecutionException
   {
      CompletableFuture<String> completableFutureBigCompute = CompletableFuture.supplyAsync(() -> {
         TestUtils.sleep(5000);
         return "10";
      });

      CompletableFuture<Double> thenCompose = completableFutureBigCompute
         .thenCompose(CompletableFutureThen::continueWithVeryImportantThing);

      CompletableFuture<CompletableFuture<Double>> thenApply = completableFutureBigCompute
         .thenApply(CompletableFutureThen::continueWithSomethingElse);

      System.out.println("thenCompose " + thenCompose.get());

      System.out.println("thenApply " + thenApply.get());

      System.out.println("thenApply " + thenApply.isDone());

      CompletableFuture<Double> thenCompose2 = completableFutureBigCompute
         .thenCompose(CompletableFutureThen::continueWithVeryImportantThing);

      // difference between compose and apply
      System.out.println("thenCompose2 " + thenCompose2.get()); // then compose uses the value
      // of the source completable,
      // this is the main difference

      // thenCombine offers the possibility to combine two completables that are totally
      // independent
      String login = "dani", password = "pass", land = "spain";
      CompletableFuture<Boolean> loginCompletable = checkLogin(login, password);
      CompletableFuture<Boolean> checkLandCompletable = checkLand(land);
      CompletableFuture<String> welcomeOrNot = loginCompletable.thenCombine(checkLandCompletable,
         CompletableFutureThen::welcome);

      System.out.println(welcomeOrNot.get());
   }

   private static String welcome(Boolean login, Boolean land)
   {

      // checks both and returns
      if (login && land)
         return "welcome";
      else
         return "not welcome";

   }

   private static CompletableFuture<Boolean> checkLand(String land)
   {
      // only Spanish are allowed
      return CompletableFuture.supplyAsync(() -> {
         // big task with back end dependencies
         return "spain".equals(land);
      });
   }

   private static CompletableFuture<Boolean> checkLogin(String login, String password)
   {
      return CompletableFuture.supplyAsync(() -> {
         // very hard authentication process
         return login != null && password != null;
      });
   }

   private static CompletableFuture<Double> continueWithSomethingElse(String str)
   {
      if ("10".equals(str))
      {
         return CompletableFuture.supplyAsync(() -> {
            System.out.println("str passed is 10");
            return 22.4;
         });
      }

      return CompletableFuture.supplyAsync(() -> {
         System.out.println("str passed is not 10");
         return 11.4;
      });
   }

   private static CompletableFuture<Double> continueWithVeryImportantThing(String str)
   {
      if ("10".equals(str))
      {
         return CompletableFuture.supplyAsync(() -> {
            System.out.println("str passed is 10 in a very important task");
            return 22.5;
         });
      }

      return CompletableFuture.supplyAsync(() -> {
         System.out.println("str passed is not 10 in a very important task");
         return 11.5;
      });
   }
}
