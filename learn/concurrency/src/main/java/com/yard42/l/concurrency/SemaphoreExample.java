package com.yard42.l.concurrency;

import java.net.URL;

public class SemaphoreExample
{
   public static void main(String[] args) throws Exception
   {
      ConnectionLimiter connectionLimiter = new ConnectionLimiter(2);
      connectionLimiter.acquire(new URL("http://oracle.com"));
      connectionLimiter.acquire(new URL("http://google.com"));
      connectionLimiter.acquire(new URL("http://gmail.com"));
   }
}


