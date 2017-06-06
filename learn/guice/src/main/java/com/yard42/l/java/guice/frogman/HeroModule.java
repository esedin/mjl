package com.yard42.l.java.guice.frogman;

import com.google.inject.AbstractModule;

public class HeroModule extends AbstractModule
{
   public void configure()
   {
      bind(Vehicle.class).to(FrogMobile.class);
      bind(Vehicle.class).annotatedWith(Fast.class).to(WeaselCopter.class);
   }
}
