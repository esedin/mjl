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

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SimpleBlockingQueue
{
   private List queue = new LinkedList();

   private int limit = 10;

   public SimpleBlockingQueue(int limit)
   {
      this.limit = limit;
   }

   public static void main(String[] args) throws InterruptedException
   {
      SimpleBlockingQueue queue = new SimpleBlockingQueue(5);
      new Thread(new Producer(queue)).start();
      Thread.currentThread().sleep(1000);
      new Thread(new Consumer(queue)).start();
   }

   static class Consumer implements Runnable
   {
      private final SimpleBlockingQueue queue;

      public Consumer(SimpleBlockingQueue queue) {
         this.queue = queue;
      }

      @Override
      public void run() {
         System.out.println("[Consumer] run");
         while (true) {
            try {
               consume();
               Thread.currentThread().sleep(1500);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }

      private void consume() throws InterruptedException {
         Integer i = (Integer) queue.take();
         System.out.println("[Consumer] consumed: " + i);
      }
   }

   static class Producer implements Runnable {
      private final SimpleBlockingQueue queue;

      public Producer(SimpleBlockingQueue queue) {
         this.queue = queue;
      }

      @Override
      public void run() {
         System.out.println("[Producer] run");
         while (true) {
            try {
               queue.put(produce());
               Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }

      private Integer produce() {
         Integer i = new Random().nextInt(100);
         System.out.println("[Producer] produce: " + i);
         return i;
      }
   }

   public synchronized void put(Object item) throws InterruptedException
   {
      System.out.println("[BlockingQueue] try to put: " + item );
      while (this.queue.size() == this.limit)
      {
         System.out.println("[BlockingQueue] queue is full, waiting until space is free");
         wait();
      }

      if (this.queue.size() == 0)
      {
         System.out.println("[BlockingQueue] queue is empty, notify");
         notifyAll();
      }

      this.queue.add(item);
      System.out.println("[BlockingQueue] put ok: " + item );
   }

   public synchronized Object take() throws InterruptedException
   {
      System.out.println("[BlockingQueue] try to take");
      while (this.queue.size() == 0)
      {
         System.out.println("[BlockingQueue] queue is empty, waiting until smth is put");
         wait();
      }

      if (this.queue.size() == limit)
      {
         System.out.println("[BlockingQueue] queue is full, notify");
         notifyAll();
      }

      Object item = this.queue.remove(0);
      System.out.println("[BlockingQueue] take ok: " + item );
      return item;
   }
}
