/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.java8;

import org.junit.Assert;
import org.junit.Test;

public class FunctionalInterfaceTest
{
   @Test
   public void testFuncInterfaces()
   {
      Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
      Integer converted = converter.convert("123");
      Assert.assertEquals(converted, new Integer(123));
   }

   @Test
   public void testFuncInterfaces_2()
   {
      Converter<String, Integer> converter = Integer::valueOf;
      Integer converted = converter.convert("123");
      Assert.assertEquals(converted, new Integer(123));
   }

   @Test
   public void testFuncInterfaces_3()
   {
      Converter<String, String> converter = Smth::startWith;
      String converted = converter.convert("123");
      Assert.assertEquals(converted, "1");
   }

   static class Smth {
      static String startWith(String s)
      {
         return String.valueOf(s.charAt(0));
      }
   }
}
