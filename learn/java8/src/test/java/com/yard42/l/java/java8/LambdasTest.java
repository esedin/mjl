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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LambdasTest
{
   static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

   @Test
   public void testComparator()
   {
      Collections.sort(names, (String a, String b) -> a.compareTo(b));

      Assert.assertTrue(names.get(0).equals("anna"));
   }

   @Test
   public void testComparator_2()
   {
      Collections.sort(names, (a, b) -> a.compareTo(b));

      Assert.assertTrue(names.get(0).equals("anna"));
   }

   @Test
   public void testComparator_3()
   {
      Collections.sort(names, String::compareTo);

      Assert.assertTrue(names.get(0).equals("anna"));
   }
}
