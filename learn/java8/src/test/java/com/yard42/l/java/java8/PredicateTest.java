package com.yard42.l.java.java8;/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

public class PredicateTest
{
   @Test
   public void predicateExampleTest()
   {
      Predicate<String> isTwoOrLessLetterWord = (s) -> s.length() <= 2;

      Assert.assertTrue(isTwoOrLessLetterWord.test("ss"));
      Assert.assertTrue(isTwoOrLessLetterWord.test(""));
      Assert.assertFalse(isTwoOrLessLetterWord.test("123"));
   }
}
