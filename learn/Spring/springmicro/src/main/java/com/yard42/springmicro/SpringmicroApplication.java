package com.yard42.springmicro;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.ipc.netty.http.server.HttpServer;

public class SpringmicroApplication
{
   static RouterFunction getRouter()
   {
      HandlerFunction<ServerResponse> hello = request -> ok().body(fromObject("Hello"));

      return
         route(GET("/"), hello).andRoute(
            GET("/json"),
            request -> ok().contentType(APPLICATION_JSON).body(fromObject(new Person("Robo", "Cop")))
         );
   }

   public static void main(String[] args) throws InterruptedException
   {
      RouterFunction router = getRouter();

      HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);

      HttpServer
         .create("localhost", 9090)
         .newHandler(new ReactorHttpHandlerAdapter(httpHandler))
         .block();

      Thread.currentThread().join();
   }
}
