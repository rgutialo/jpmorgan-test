package com.jproject.util;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;


public class WeekDaysTest{

	@Test
	public void getNextDayForRegularWeekOK()
	{
		LocalDate saturdayDate = LocalDate.of(2018, Month.MARCH, 24);
		LocalDate nextDate = WeekDays.getNextWeekDay(saturdayDate, "EUR");
		assertEquals(nextDate.getYear(),2018);
		assertEquals(nextDate.getMonth(),Month.MARCH);
		assertEquals(nextDate.getDayOfMonth(),26);
	}
	
	@Test
	public void getNextDayForAabianWeekOK()
	{
		LocalDate saturdayDate = LocalDate.of(2018, Month.MARCH, 24);
		LocalDate nextDate = WeekDays.getNextWeekDay(saturdayDate, "AED");
		assertEquals(nextDate.getYear(),2018);
		assertEquals(nextDate.getMonth(),Month.MARCH);
		assertEquals(nextDate.getDayOfMonth(),25);
	}
}
