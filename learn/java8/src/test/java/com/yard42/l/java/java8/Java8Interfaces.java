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

public class Java8Interfaces
{
   @Test
   public void testDefault()
   {
      Formula formula = a -> a * 3;

      Assert.assertEquals(formula.calculate(3), 9);
      Assert.assertEquals(formula.sqr(2), 4);
   }
}
