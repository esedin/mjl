package com.yard42.springmicro;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class SpringmicroApplicationTests
{
   private final WebTestClient webTestClient =
      WebTestClient
         .bindToRouterFunction(SpringmicroApplication.getRouter())
         .build();

   @Test
   public void indexPage_WhenRequested_SaysHello()
   {
      webTestClient.get().uri("/").exchange()
         .expectStatus().is2xxSuccessful()
         .expectBody(String.class)
         .isEqualTo("Hello");
   }

   @Test
   @Ignore
   public void jsonPage_WhenRequested_SaysHello()
   {
      webTestClient.get().uri("/json").exchange()
         .expectStatus().is2xxSuccessful()
         .expectHeader().contentType(APPLICATION_JSON)
         .expectBody(Person.class)
         .isEqualTo(new Person("Robo", "Cop"));
   }
}
