package com.yard42.learn.java;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

import com.yard42.l.java.Repeat;
import com.yard42.l.java.TestRunner;

@RunWith(TestRunner.class)
public class TestMerge
{
   @Test
   @Repeat(10)
   public void testMergeSort()
   {
      int[] arrayToSort = Data.buildRandomArray(30);
      int[] arrayToSort1 = Arrays.copyOf(arrayToSort, arrayToSort.length);

      Merge.mergeSort(arrayToSort, 0, arrayToSort.length - 1);

      Arrays.sort(arrayToSort1);

      assertArrayEquals(arrayToSort, arrayToSort1);
   }
}
