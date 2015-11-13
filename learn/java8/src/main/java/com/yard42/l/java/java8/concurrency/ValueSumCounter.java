/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.java8.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import com.yard42.l.java.Utils.Node;

public class ValueSumCounter extends RecursiveTask<Long>
{
   private Node node;

   public ValueSumCounter(Node node)
   {
      this.node = node;
   }

   @Override
   protected Long compute()
   {
      long sum = node.getValue();

      List<ValueSumCounter> subTasks = new LinkedList<>();

      for (Node child : node.getChildren())
      {
         ValueSumCounter task = new ValueSumCounter(child);
         task.fork();
         subTasks.add(task);
      }

      for(ValueSumCounter task : subTasks)
      {
         sum+=task.join();
      }

      return sum;
   }

   public static void main(String[] args)
   {
      Node root = new Node()
      {
         @Override
         public Collection<Node> getChildren()
         {
            return new ArrayList<Node>();
         }

         @Override
         public long getValue()
         {
            return 0;
         }
      };

      new ForkJoinPool().invoke(new ValueSumCounter(root));
   }
}
