/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceClass extends Reducer<Text, IntWritable, Text, IntWritable>
{
   @Override
   protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
   {
      int sum = 0;

      for (IntWritable value : values)
      {
         sum += value.get();
      }

      context.write(key, new IntWritable(sum));
   }
}
