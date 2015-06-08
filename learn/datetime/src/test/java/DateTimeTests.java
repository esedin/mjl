import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

public class DateTimeTests
{
   @Test
   public void localDateNow()
   {
      LocalDate today = LocalDate.now();
      System.out.println("Today's Local date : " + today);
   }

   @Test
   public void particularDate()
   {
      LocalDate localDate = LocalDate.of(2014, 12, 10);

      Assert.assertEquals(localDate.toString(), "2014-12-10");
   }

   @Test
   public void recurringEvent()
   {

   }

   @Test
   public void plusHour()
   {
      LocalTime time = LocalTime.of(23, 30);
      LocalTime afterTwoHour = time.plusHours(2);

      Assert.assertEquals(afterTwoHour.toString(), "01:30");
   }

   @Test
   public void dateAfterWeek()
   {
      LocalDate test = LocalDate.of(2011, 1, 3);

      LocalDate date = LocalDate.of(2010, 12, 27);
      LocalDate afterWeek = date.plus(1, ChronoUnit.WEEKS);

      Assert.assertEquals(afterWeek, test);
   }

   @Test
   public void isBefore()
   {
      LocalDate today = LocalDate.now();
      LocalDate yesterday = today.minusDays(1);

      Assert.assertTrue(yesterday.isBefore(today));
   }
}