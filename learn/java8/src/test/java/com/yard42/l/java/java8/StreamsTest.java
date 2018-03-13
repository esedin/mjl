package com.yard42.l.java.java8;

import static com.yard42.l.java.java8.TestUtils.assertStreamEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamsTest
{
   private List<String> collectionStr;

   @Before
   public void initCollection()
   {
      collectionStr = new ArrayList<>();
      collectionStr.add("uno");
      collectionStr.add("dos");
      collectionStr.add("tres");
      collectionStr.add("cuatro");
      collectionStr.add("cinco");
      collectionStr.add("seis");
      collectionStr.add("siete");
      collectionStr.add("ocho");
   }

   @Test
   public void filterTest()
   {
      Stream<String> filtered = collectionStr.stream().filter((s) -> s.startsWith("s"));
      assertStreamEquals(
         filtered,
         Stream.of("seis", "siete")
      );
   }

   @Test
   public void mapTest()
   {
      Stream<String> mapped = collectionStr.stream().map(String::toUpperCase);
      assertStreamEquals(
         mapped,
         Stream.of("UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO")
      );
   }

   @Test
   public void reduceTest()
   {
      Optional<String> reduced = collectionStr.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

      reduced.ifPresent(System.out::println);

      assertEquals(reduced.get(), "cinco#cuatro#dos#ocho#seis#siete#tres#uno");
   }
}
