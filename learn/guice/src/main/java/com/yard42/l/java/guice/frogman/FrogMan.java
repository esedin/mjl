package com.yard42.l.java.guice.frogman;

import com.google.inject.Inject;

public class FrogMan
{
   private Vehicle vehicle;

   @Inject
   public FrogMan(Vehicle vehicle)
   {
      this.vehicle = vehicle;
   }

   public String sayName()
   {
      return vehicle.getName();
   }
}
