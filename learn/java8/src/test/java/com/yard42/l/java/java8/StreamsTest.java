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

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StreamsTest
{
   private static List<String> getList()
   {
      List<String> stringCollection = new ArrayList<>();
      stringCollection.add("ddd2");
      stringCollection.add("aaa2");
      stringCollection.add("bbb1");
      stringCollection.add("aaa1");
      stringCollection.add("bbb3");
      stringCollection.add("ccc");
      stringCollection.add("bbb2");
      stringCollection.add("ddd1");

      return stringCollection;
   }

   @Test
   public void streamTest()
   {
      getList().stream().filter(s -> s.startsWith("a")).forEach(System.out::println);

      System.out.println(ZoneId.getAvailableZoneIds());
   }

}
