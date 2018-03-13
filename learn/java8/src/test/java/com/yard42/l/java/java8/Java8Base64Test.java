package com.yard42.l.java.java8;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Test;

public class Java8Base64Test
{
   @Test
   public void encodeTest() throws UnsupportedEncodingException
   {
      String str = "this is an string";
      String strEncoded = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));

      assertEquals("dGhpcyBpcyBhbiBzdHJpbmc=", strEncoded);
   }

   @Test
   public void decodeTest() throws IOException
   {
      String str = "this is an string";
      byte[] strDecoded = Base64.getDecoder().decode("dGhpcyBpcyBhbiBzdHJpbmc=");

      assertEquals(str, new String(strDecoded, StandardCharsets.UTF_8));
   }
}
