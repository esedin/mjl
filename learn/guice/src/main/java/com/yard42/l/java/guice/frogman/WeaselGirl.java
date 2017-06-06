package com.yard42.l.java.guice.frogman;

import com.google.inject.Inject;

public class WeaselGirl
{
   private Vehicle vehicle;

   @Inject
   public WeaselGirl(@Fast Vehicle vehicle)
   {
      this.vehicle = vehicle;
   }

   public String sayName()
   {
      return vehicle.getName();
   }
}
