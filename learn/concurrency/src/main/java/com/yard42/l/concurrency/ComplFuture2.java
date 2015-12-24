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

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;

public class ComplFuture2
{
   public static void main(String[] args)
   {
      ComplFuture2 complFuture2 = new ComplFuture2();
      complFuture2.run();
   }

   private void run()
   {
      ExecutorService executor = Executors.newFixedThreadPool(4);

      List<String> topSites = Arrays.asList(
         "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com"
      );

         topSites.stream().
         map(site -> CompletableFuture.supplyAsync(() -> downloadSite(site), executor)).
         map(contentFuture -> contentFuture.thenApply(this::parse)).
         map(docFuture -> docFuture.thenCompose(this::calculateRelevance)).
         collect(Collectors.<CompletableFuture<Double>>toList());
   }

   private CompletableFuture<Double> calculateRelevance(Document doc)
   {
      try{
         System.out.println("calculateRelevance");
         Thread.sleep(1000);
      }
      catch (InterruptedException ex)
      {
         System.out.println("Interrupted");
      }

      return CompletableFuture.supplyAsync(()-> (double) 10);
   }

   private Document parse(String xml)
   {
      try{
         System.out.println("parse");
         Thread.sleep(5000);
      }
      catch (InterruptedException ex)
      {
         System.out.println("Interrupted");
      }

      return null;
   }

   public String downloadSite(final String site)
   {
      try
      {
         System.out.println("Downloading site: " + site);
         final String res = IOUtils.toString(new URL("http://"+site), Charsets.UTF_8);
         System.out.println("Downloading done.");
         return res;
      }
      catch (IOException ex)
      {
         throw Throwables.propagate(ex);
      }
   }
}
