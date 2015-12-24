/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ComplFuture
{
   public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException
   {
      CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
         try{
            Thread.sleep(10000);
         }
         catch (InterruptedException ex)
         {
           return  ex.getCause().toString();
         }

         return "100";
      });

      //
      //System.out.println(completableFuture.getNow("now"));
      try
      {
         System.out.println("get in 3 seconds " + completableFuture.get(3, TimeUnit.SECONDS));
      }
      catch (TimeoutException ex)
      {
         System.out.println(ex.toString());
      }

      System.out.println(completableFuture.get());
   }
}
