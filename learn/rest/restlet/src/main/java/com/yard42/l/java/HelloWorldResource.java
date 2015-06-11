/*
 * This module is part of the CSF experimental system
 * Copyright (c) Soft Computer Consultants, Inc.
 * All Rights Reserved
 * This document contains unpublished, confidential and proprietary
 * information of Soft Computer Consultants, Inc. No disclosure or use of
 * any portion of the contents of these materials may be made without the
 * express written consent of Soft Computer Consultants, Inc.
 */
package com.yard42.l.java;

import java.util.Map;

public class HelloWorldResource extends BaseResource
{
   public String processRequest(Map json, String method)
   {
      String returnString = "";
      returnString = new ResponseParseFactory().getSuccessJsonString("Hello " + json.get("user"));
      return returnString;
   }
}