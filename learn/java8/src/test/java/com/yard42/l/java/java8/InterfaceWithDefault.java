package com.yard42.l.java.java8;

public interface InterfaceWithDefault
{
   default void defaultMethod()
   {
      System.out.println("Default method");
   }

   void toImplement();
}
