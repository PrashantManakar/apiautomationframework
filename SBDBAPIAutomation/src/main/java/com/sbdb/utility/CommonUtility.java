/**
 * 
 */
package com.sbdb.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pmanakar
 *
 */
public class CommonUtility {


	/**
	 * This method will return the List<Dates> between start date and End Dates
	 * @param dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */

	public static List<Date> getBetweenDatesFromResponse(List<Date> dates,Date startDate,Date endDate){		
		return dates.stream().filter(x-> x.after(startDate) && x.before(endDate)).collect(Collectors.toList());
	}

	/**
	 * This method will return the List<Dates> between start date and End Dates
	 * @param dates
	 * @param startDate
	 * @param endDate
	 * @return boolean
	 */

	public static boolean verifyListBetweenDatesFromResponse(List<Date> dates,Date startDate,Date endDate){		
		return dates.stream().filter(x-> x.after(startDate) && x.before(endDate)).findFirst().isPresent() ? false:true;

	}



	/**
	 * This method will return the future or Past Dates 
	 * Use positive number for future date and negative number for past date 
	 * @param days
	 * @param format
	 * @return String
	 */

	public static String getPastFutureDate(int days, String format) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, days); // Example : Adds 15 days
		Date date = c.getTime();
		DateFormat dateFormat = new SimpleDateFormat(format);  
		String strDate = dateFormat.format(date);  
		return strDate;
	}

	/**
	 * Match two list with equals method
	 * @param userData
	 * @param applicationdata
	 * @return
	 */
	public boolean matchTwoListWithEqualsMethod(List<Date> userData,List<Date> applicationdata) {
		return applicationdata.stream().filter(x -> userData.stream().noneMatch(y -> {
			if(y.compareTo(x) == 0)
				return true;
			return false;
		}
				)).findFirst().isPresent()? false:true;
	}

	/**
	 *  
	 * @param dateToConvert
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static  Date convertStringToDate(String dateToConvert,String format) throws ParseException{
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(dateToConvert);

	}
}


