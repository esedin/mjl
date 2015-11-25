/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample
{
   private int calcVal;

   private int val;

   private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

   public void calculate(int value)
   {
      readWriteLock.writeLock().lock();
      try
      {
         this.val = value;
         this.calcVal = doSlowCalculation(value);
      }
      finally
      {
         readWriteLock.writeLock().unlock();
      }
   }

   public int getCalculatedValue()
   {
      readWriteLock.readLock().lock();
      try
      {
         return this.calcVal;
      }
      finally
      {
         readWriteLock.readLock().unlock();
      }
   }

   public int getValue()
   {
      readWriteLock.readLock().lock();
      try
      {
         return this.val;
      }
      finally
      {
         readWriteLock.readLock().unlock();
      }
   }

   private int doSlowCalculation(int value)
   {
      try
      {
         Thread.sleep(5000);
         return -value;
      }
      catch (InterruptedException e)
      {
         return 0;
      }
   }
}
