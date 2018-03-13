package com.yard42.l.java.java8;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OptionalFeature
{
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

   @Before
   public void setUpStreams()
   {
      System.setOut(new PrintStream(outContent));
   }

   @Test(expected = NoSuchElementException.class)
   public void getEmptyTest()
   {
      Optional emptyOptional = Optional.empty();
      emptyOptional.get();
   }

   @Test
   public void orElseTest()
   {
      String str = "test string";
      Optional<String> nonEmptyOptional = Optional.of(str);

      String strNull = null;
      Optional nullableOptional = Optional.ofNullable(strNull);

      assertEquals("Optional[test string]", nullableOptional.orElse(nonEmptyOptional).toString());
   }

   @Test(expected = IllegalStateException.class)
   public void orElseThrowTest() throws Throwable
   {
      Optional nullableOptional = Optional.ofNullable(null);
      System.out.println(nullableOptional.orElseThrow(IllegalStateException::new));
   }

   @Test
   public void ifPresentTest()
   {
      String a = "optional is there";

      Optional<String> stringToUse = Optional.of(a);
      stringToUse.ifPresent(System.out::print);

      assertEquals(a, outContent.toString());
   }

   @Test
   public void filterTest()
   {
      Optional<Car> carOptionalEmpty = Optional.empty();
      carOptionalEmpty.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.print(x.getPrice() + " is ok!"));

      assertEquals("", outContent.toString());

      Optional<Car> carOptionalExpensive = Optional.of(new Car("3333"));
      carOptionalExpensive.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.print(x.getPrice() + " is ok!"));

      assertEquals("", outContent.toString());

      Optional<Car> carOptionalOk = Optional.of(new Car("250"));
      carOptionalOk.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.print(x.getPrice() + " is ok!"));

      assertEquals("250 is ok!", outContent.toString());
   }

   @Test
   public void mapTest()
   {
      Optional<String> stringOptional = Optional.of("loooooooong string");
      Optional<Integer> sizeOptional = stringOptional.map(String::length);
      assertEquals(18, sizeOptional.orElse(0).intValue());

      Optional<String> stringOptionalNull = Optional.ofNullable(null);
      Optional<Integer> sizeOptionalNull = stringOptionalNull.map(x -> x.length());
      assertEquals(0, sizeOptionalNull.orElse(0).intValue());
   }

   @After
   public void cleanUpStreams()
   {
      System.setOut(null);
   }

   private class Car
   {
      String price;

      Car(String price)
      {
         this.price = price;
      }

      String getPrice()
      {
         return price;
      }
   }
}
