package com.jproject.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeekDays {
	
	public static String AED = "AED";
	public static String SAR = "SAR";
	private static final Map<DayOfWeek, Boolean> defaultWeek;
	private static final Map<DayOfWeek, Boolean> arabianWeek;
    static {
    	Map<DayOfWeek, Boolean> tempRegularWeek = new HashMap<DayOfWeek, Boolean>();
    	tempRegularWeek.put(DayOfWeek.MONDAY, new Boolean(true));
    	tempRegularWeek.put(DayOfWeek.TUESDAY, new Boolean(true));
    	tempRegularWeek.put(DayOfWeek.WEDNESDAY, new Boolean(true));
    	tempRegularWeek.put(DayOfWeek.THURSDAY, new Boolean(true));
    	tempRegularWeek.put(DayOfWeek.FRIDAY, new Boolean(true));
    	tempRegularWeek.put(DayOfWeek.SATURDAY, new Boolean(false));
    	tempRegularWeek.put(DayOfWeek.SUNDAY, new Boolean(false));
    	
        defaultWeek = Collections.unmodifiableMap(tempRegularWeek);
    }
    
    static {
    	Map<DayOfWeek, Boolean> tempArabianWeek = new HashMap<DayOfWeek, Boolean>();
    	tempArabianWeek.put(DayOfWeek.MONDAY, new Boolean(true));
    	tempArabianWeek.put(DayOfWeek.TUESDAY, new Boolean(true));
    	tempArabianWeek.put(DayOfWeek.WEDNESDAY, new Boolean(true));
    	tempArabianWeek.put(DayOfWeek.THURSDAY, new Boolean(true));
    	tempArabianWeek.put(DayOfWeek.FRIDAY, new Boolean(false));
    	tempArabianWeek.put(DayOfWeek.SATURDAY, new Boolean(false));
    	tempArabianWeek.put(DayOfWeek.SUNDAY, new Boolean(true));
    	
    	arabianWeek = Collections.unmodifiableMap(tempArabianWeek);
    }
	private WeekDays() {};
	
	public static LocalDate getNextWeekDay (final LocalDate date, final String currency)
	{
		if (isWeekDay(date,currency))
			return date;
		else
			return getNextWeekDay(date.plusDays(1), currency);
	}
	
	private static Boolean isWeekDay(final LocalDate date,final String currency)
	{
		if (WeekDays.AED.equals(currency) || WeekDays.SAR.equals(currency))
		{
			return WeekDays.arabianWeek.get(date.getDayOfWeek());					
		}
		else
		{
			return WeekDays.defaultWeek.get(date.getDayOfWeek());
		}
			
	}

	
	

}
