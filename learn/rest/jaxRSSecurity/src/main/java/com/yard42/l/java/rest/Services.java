/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class Services
{
   @GET
   @Path("/student/list")
   @Produces(MediaType.APPLICATION_JSON)
   public List studentList()
   {
      List studentList = new ArrayList();
      Student st1 = new Student();
      st1.setFirstName("Bart");
      st1.setLastName("Simpson");
      st1.setSchool("Springfield School");
      studentList.add(st1);

      Student st2 = new Student();
      st2.setFirstName("Bruce");
      st2.setLastName("Wayne");
      st2.setSchool("Gotham High School");
      studentList.add(st2);

      return studentList;
   }

   @GET
   @Path("/student/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Student studentById(@PathParam("id") int id)
   {
      Student st1 = new Student();
      st1.setFirstName("Jim");
      st1.setLastName("Worm");
      st1.setSchool("Underground School");
      st1.setId(id);

      return st1;
   }
}
