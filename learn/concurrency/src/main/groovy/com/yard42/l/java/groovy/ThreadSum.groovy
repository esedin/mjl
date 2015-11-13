/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.groovy;

import java.util.concurrent.Callable
import java.util.concurrent.Executors;

class Sum
{
   static monitor = new Object();
   static volatile long sum = 0;
}

class Summer implements Callable
{
   long[] data;

   Object call() throws Exception
   {
      data.each {
         synchronized (com.yard42.l.java.groovy.Sum.monitor) {
            println("${Thread.currentThread().name}: add ${it} to ${com.yard42.l.java.groovy.Sum.sum}")
            com.yard42.l.java.groovy.Sum.sum += it;
         }
      }
   }
}

Executors.newFixedThreadPool(2).invokeAll([
   new Summer(data:[1,2,3,4,5]),
   new Summer(data:[-1,-2,-3,-4,-5])
])

print ("ThreadSum: ${com.yard42.l.java.groovy.Sum.sum}")