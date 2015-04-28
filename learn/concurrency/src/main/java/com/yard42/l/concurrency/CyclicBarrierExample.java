package com.yard42.l.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierExample {
    private static class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (Exception ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run(){
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "Thread 1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "Thread 2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
