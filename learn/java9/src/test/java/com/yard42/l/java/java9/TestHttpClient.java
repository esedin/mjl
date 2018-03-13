package com.yard42.l.java.java9;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class TestHttpClient
{
   @Test
   public void httpClientTest()
   {
      HttpClient httpClient = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create("http://openjdk.java.net/"))
         .GET().build();

      CompletableFuture<HttpResponse<String>> response
         = httpClient.sendAsync(request, HttpResponse.BodyHandler.asString());

      try
      {
         Thread.sleep(1000);

         if (response.isDone())
         {
            assert response.get().statusCode() == 200;
         }
         else
         {
            assert false;
         }
      }
      catch (InterruptedException | ExecutionException e)
      {
         e.printStackTrace();
      }
   }
}
