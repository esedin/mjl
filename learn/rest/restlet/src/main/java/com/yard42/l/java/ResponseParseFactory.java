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

import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.json.simple.JSONValue;

public class ResponseParseFactory
{
   static Logger logger = Logger.getLogger(ResponseParseFactory.class);

   @SuppressWarnings({"rawtypes", "unchecked"})
   public String getFailureJsonString(String msg)
   {
      String jsonString = "";
      LinkedHashMap list = new LinkedHashMap();
      list.put("response_status", "false");

      list.put("result", msg + "");
      jsonString = JSONValue.toJSONString(list);
      logger.info(jsonString);
      return jsonString;
   }

   @SuppressWarnings({"rawtypes", "unchecked"})
   public String getSuccessJsonString(String msg)
   {
      String jsonString = "";
      LinkedHashMap list = new LinkedHashMap();
      list.put("response_status", "true");

      list.put("result", msg);
      jsonString = JSONValue.toJSONString(list);
      logger.info(jsonString);
      return jsonString;
   }
}