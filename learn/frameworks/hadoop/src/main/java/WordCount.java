/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCount extends Configured implements Tool
{
   public static void main(String[] args) throws Exception
   {
      int exitCode = ToolRunner.run(new WordCount(), args);
      System.exit(exitCode);
   }

   @Override
   public int run(String[] args) throws Exception
   {
      if (args.length != 2)
      {
         System.err.printf("Usage: %s needs two arguments, input and output files\n", getClass().getSimpleName());
         return -1;
      }

      Job job = new Job();
      job.setJarByClass(WordCount.class);
      job.setJobName("WordCounter");

      FileInputFormat.addInputPath(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));

      job.setOutputKeyClass(Text.class);
      job.setMapOutputValueClass(IntWritable.class);
      job.setOutputFormatClass(TextOutputFormat.class);

      job.setMapperClass(MapClass.class);
      job.setReducerClass(ReduceClass.class);

      int returnValue = job.waitForCompletion(true) ? 0 : 1;

      if (job.isSuccessful())
      {
         System.out.println("Done!!");
      }
      else
      {
         System.out.println("Fail!");
      }

      return returnValue;
   }
}
