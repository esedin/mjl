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

public class TailCallTest
{
   static TailCall<Integer> addRec(int x, int y)
   {
      return y==0 ? TailCall.ret(x) : TailCall.sus(() -> addRec(x + 1, y - 1));
   }

   static int add(int x, int y)
   {
      return addRec(x, y).eval();
   }

   static int addPureRec(int x, int y) {
      return y == 0 ? x : addPureRec(++x, --y);
   }

   @Test
   public void testTailCall()
   {
      Assert.assertEquals(add(50, 50000), 50050);
   }

   @Test(expected = StackOverflowError.class)
   public void testRec() {
      addPureRec(50, 50000);
   }
}
