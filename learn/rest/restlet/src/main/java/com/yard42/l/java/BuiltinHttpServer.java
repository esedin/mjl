/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class BuiltinHttpServer
{
   public static void main(String[] args)
   {
      final String payload = "Said";
      try
      {
         HttpServer server = HttpServer.create(new InetSocketAddress(4343), 0);
         HttpContext context = server.createContext("/java");
         context.setHandler(new HttpHandler()
         {
            public void handle(HttpExchange httpExchange) throws IOException
            {
               httpExchange.sendResponseHeaders(200, payload.getBytes().length);
               final OutputStream output = httpExchange.getResponseBody();
               output.write(payload.getBytes());
               output.flush();
               httpExchange.close();
            }
         });

         server.start();
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }
}
