package com.yard42.l.java.java8;

public class InterfaceWithDefaultImpl implements InterfaceWithDefault
{
   @Override
   public void toImplement()
   {
      System.out.println("Implemented");
   }

   public static void main(String[] args)
   {
      InterfaceWithDefault interfaceWithDefault = new InterfaceWithDefaultImpl();
      interfaceWithDefault.defaultMethod();
   }
}
