/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.java8;

import java.util.Arrays;
import java.util.function.BiFunction;

public class LambdasAndFunctional
{
   public static void main(String[] args)
   {
      Arrays.asList("a", "b", "d").forEach( e -> System.out.println( e ) );

      Arrays.asList( "a", "b", "d" ).forEach( e -> {
         System.out.print( e );
         System.out.println(e);
      } );

      BiFunction<Integer, Integer, Integer> addition = (x, y) -> x + y;
      System.out.println(addition.apply(1,2));

      Runnable r = () -> System.out.println("run run run");
      Thread t = new Thread(r);
      t.start();
   }
}
