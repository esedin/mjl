package com.yard42.l.java.java8;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.stream.Stream;

public class TestUtils
{
   public static void sleep(long millis)
   {
      try
      {
         Thread.sleep(millis);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }

   public static void assertStreamEquals(Stream<?> s1, Stream<?> s2)
   {
      Iterator<?> iterator1 = s1.iterator(), iterator2 = s2.iterator();

      while (iterator1.hasNext() && iterator2.hasNext())
      {
         assertEquals(iterator1.next(), iterator2.next());
      }

      assert !iterator1.hasNext() && !iterator2.hasNext();
   }
}
