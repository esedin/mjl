/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.yard42.l.java.guava.ImmutableCollectors;

public class ImmutableCollectorsTest
{
   @Test
   public void testImmutableList()
   {
      List<String> things = Lists.newArrayList("Apple", "Ajax", "Anna", "banana", "cat", "foo", "dog", "cat");

      List<String> aWords = things.stream().filter(w -> w.startsWith("A")).collect(ImmutableCollectors.ofList());

      assertThat(aWords.contains("Apple"), is(true));
      assertThat(aWords instanceof ImmutableList, is(true));
      assertThat(aWords.size(), is(3));
      boolean unableToModifyList = false;
      try
      {
         aWords.add("Bad Move");
      }
      catch (UnsupportedOperationException e)
      {
         unableToModifyList = true;
      }
      assertTrue("Should not be able to modify list", unableToModifyList);
   }
}
