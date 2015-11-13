/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.groovy

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicLong

class AtomSum {
   static volatile AtomicLong sum = new AtomicLong(0);
}

class AtomicSummer implements Callable{
   long[] data;

   Object call() throws Exception {
      data.each {
         while (true)
         {
            long localSum = AtomSum.sum.get();
            if (AtomSum.sum.compareAndSet(localSum, localSum + it)) {
               println("${Thread.currentThread().name}: add ${it} to ${AtomSum.sum}")
               break;
            }
            else {
               println("[!MISS] ${Thread.currentThread().name}: add ${it} to ${AtomSum.sum}")
            }
         }
      }
   }
}

Executors.newFixedThreadPool(2).invokeAll([
   new AtomicSummer(data:[1,2,3,4,5,6,7,8,9,10]),
   new AtomicSummer(data:[-1,-2,-3,-4,-5,-6,-7,-8,-9,-10])
])

print ("ThreadSum: ${AtomSum.sum}")

