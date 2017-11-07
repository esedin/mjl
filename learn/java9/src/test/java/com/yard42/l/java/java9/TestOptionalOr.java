package com.yard42.l.java.java9;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class TestOptionalOr
{
   @Test
   public void or()
   {
      int message = this.answer().map(Integer::parseInt).
         or(this::defaultAnswer).get();

      assertThat(message, is(42));
   }

   private Optional<String> answer()
   {
      return Optional.ofNullable(null);
   }

   private Optional<Integer> defaultAnswer()
   {
      return Optional.of(42);
   }
}

