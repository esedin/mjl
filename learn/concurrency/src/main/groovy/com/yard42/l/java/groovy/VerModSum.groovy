package com.yard42.l.java.groovy

import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

class Transaction {
   long debit
}

class Account {
   AtomicLong version = new AtomicLong()
   ReadWriteLock readWriteLock = new ReentrantReadWriteLock()
   List<Transaction> transactions = new ArrayList<Transaction>()
}

long balance(Account account) {
   ReentrantReadWriteLock.ReadLock locked
   while (true) {
      long balance = 0;
      long version = account.version.get();
      account.transactions.each {
         balance += it.debit
      }

      if (account.version.compareAndSet(version, version)) {
         if (locked) {
            locked.unlock()
         }
         return balance;
      } else {
         locked = account.readWriteLock.readLock()
      }
   }
}

void modifyTransaction(Account account, int position, long newDebit) {
   def writeLock = account.readWriteLock.writeLock()
   account.version.incrementAndGet()
   account.transactions[position].debit = newDebit
   writeLock.unlock()
}