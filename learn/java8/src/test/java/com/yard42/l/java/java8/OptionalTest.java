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

import java.util.Optional;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

public class OptionalTest
{
   @Test
   public void optionalTest()
   {
      Optional<String> optional = Optional.of("bang");

      Assert.assertTrue(optional.isPresent());
      Assert.assertEquals(optional.get(), "bang");
      Assert.assertEquals(optional.orElse("Big"), "bang");

      Consumer<String> consumer = new Consumer<String>()
      {
         @Override
         public void accept(String s)
         {
            System.out.println(s.charAt(0));
         }
      };

      optional.ifPresent(consumer);
   }
}
