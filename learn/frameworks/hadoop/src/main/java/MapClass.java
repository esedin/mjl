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
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapClass extends Mapper<LongWritable, Text, Text, IntWritable>
{
   private final static IntWritable one = new IntWritable(1);
   private final Text word = new Text();

   @Override
   protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
   {
      String line = value.toString();
      StringTokenizer st = new StringTokenizer(line, " ");

      while (st.hasMoreTokens())
      {
         word.set(st.nextToken());
         context.write(word, one);
      }
   }
}
