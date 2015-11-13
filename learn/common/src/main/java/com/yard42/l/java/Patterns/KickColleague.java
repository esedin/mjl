/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.Patterns;

public class KickColleague implements ColleagueVisitor
{
   public static void main(String[] args)
   {
      KickColleague kickColleague = new KickColleague();
      Colleague olek = new Olek();
      Colleague vfro = new Vfro();
      olek.visit(kickColleague);
      vfro.visit(kickColleague);
   }

   @Override
   public void visit(Olek olek)
   {
      System.out.println("Olek kicked");
   }

   @Override
   public void visit(Vfro vfro)
   {
      System.out.println("Vfro kicked");
   }
}
