/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.Patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer
{
   public static void main(String[] args)
   {
      BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
      Producer producer = new Producer(queue);
      Consumer consumer = new Consumer(queue);
      producer.start();
      consumer.start();
   }
}

class Producer extends Thread
{
   private BlockingQueue<Integer> queue;

   public Producer(BlockingQueue<Integer> queue)
   {
      super("Producer");
      this.queue = queue;
   }

   @Override
   public void run()
   {
      for (int i = 0; i < 10; i++)
      {
         try
         {
            System.out.println(getName() + " produced " + i);
            queue.put(i);
            //Thread.sleep(200);
         }
         catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
}

class Consumer extends Thread
{
   private BlockingQueue<Integer> queue;

   public Consumer(BlockingQueue<Integer> queue)
   {
      super("Consumer");
      this.queue = queue;
   }

   public void run()
   {
      while (true)
      {
         try
         {
            Integer item = queue.take();
            System.out.println(getName() + " consumed " + item);
         }
         catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
}