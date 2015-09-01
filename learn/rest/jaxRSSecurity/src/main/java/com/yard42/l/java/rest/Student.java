package com.yard42.l.java.rest;

public class Student
{
   String firstName, lastName;

   String school;

   int id;

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getSchool()
   {
      return school;
   }

   public void setSchool(String school)
   {
      this.school = school;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   @Override
   public String toString()
   {
      return "Student{" +
         "firstName='" + firstName + '\'' +
         ", lastName='" + lastName + '\'' +
         ", school='" + school + '\'' +
         ", id=" + id +
         '}';
   }
}
