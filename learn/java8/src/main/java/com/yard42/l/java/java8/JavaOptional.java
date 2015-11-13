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

import java.util.NoSuchElementException;
import java.util.Optional;

public class JavaOptional
{
   public static void main(String[] args)
   {
      try
      {
         Optional emptyOptional = Optional.empty();
         System.out.println(emptyOptional.get());
      }
      catch (NoSuchElementException ex)
      {
         System.out.println("expected NoSuchElementException");
      }

      String str = "string";
      Optional nonEmptyOptional = Optional.of(str);

      String strNull = null;
      Optional nullableOptional = Optional.ofNullable(strNull);

      Optional stringToUse = Optional.of("optional is there");
      if (stringToUse.isPresent())
      {
         System.out.println(stringToUse.get());
      }

      stringToUse.ifPresent(System.out::println);

      Optional<String> stringOptional = Optional.of("loooooooong string");
      Optional<Integer> sizeOptional = stringOptional.map(String::length);
      System.out.println("size of string " + sizeOptional.orElse(0));

      Optional<String> stringOptionalNull = Optional.ofNullable(null);
      Optional sizeOptionalNull = stringOptionalNull.map(x -> x.length());
      System.out.println("size of string " + sizeOptionalNull.orElse(0));
   }
}
