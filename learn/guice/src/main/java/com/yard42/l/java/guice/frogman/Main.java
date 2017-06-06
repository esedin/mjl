package com.yard42.l.java.guice.frogman;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
   public static void main(String[] args)
   {
      Injector injector = Guice.createInjector(new HeroModule());
      FrogMan hero = injector.getInstance(FrogMan.class);
      WeaselGirl weaselGirl = injector.getInstance(WeaselGirl.class);
      System.out.println(hero.sayName());
      System.out.println(weaselGirl.sayName());
   }
}
