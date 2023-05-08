/*
 * Created on Jan 30, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author thornalt
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class date {
	public static void main(String[] args) {
		int num_datasets;
		String name;
		int currMonth, currDay, currYear, numDays, numDaysInMonth;
		String monthString, dayString;
		String monthNames[] = {	"January",
								"February",
								"March",
								"April",
								"May",
								"June",
								"July",
								"August",
								"September",
								"October",
								"November",
								"December"	};
		
		UILFileReader input = new UILFileReader("date.in");
				
		/* Read the number of data sets */
		num_datasets = input.readInt();
				
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
					
			/*   step #1 - convert to binary */
			name = input.readWord();
			monthString = input.readWord();
			currMonth = convertMonthToNum(monthString);
			dayString = input.readWord();
			currDay = Integer.parseInt(dayString.substring(0, dayString.length() - 1));
			currYear = input.readInt();
			numDays = input.readInt();
			
			numDaysInMonth = convertNumDaysInMonth(currMonth, currYear);
			
			for (int day = 0;day < numDays; day++)
			{
				currDay++;
				if (currDay > numDaysInMonth)
				{
					currDay = 1;
					currMonth++;
					
					if (currMonth > 12)
					{
						currMonth = 1;
						currYear++;
					}
					numDaysInMonth = convertNumDaysInMonth(currMonth, currYear);
				}
			}
			/* Output the result */
			System.out.println(name + "'s 18th birthday is on " + monthNames[currMonth-1] + " " + currDay + ", " + currYear);
		}

	}
	
	public static int convertMonthToNum(String month)
	{
		if (month.compareTo("January") == 0)
			return 1;
		if (month.compareTo("February") == 0)
			return 2;
		if (month.compareTo("March") == 0)
			return 3;
		if (month.compareTo("April") == 0)
			return 4;
		if (month.compareTo("May") == 0)
			return 5;
		if (month.compareTo("June") == 0)
			return 6;
		if (month.compareTo("July") == 0)
			return 7;
		if (month.compareTo("August") == 0)
			return 8;
		if (month.compareTo("September") == 0)
			return 9;
		if (month.compareTo("October") == 0)
			return 10;
		if (month.compareTo("November") == 0)
			return 11;
		return 12;
	}
	
	public static int convertNumDaysInMonth(int month, int year)
	{
		int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		if (month == 2 && isLeapYear(year))
			return 29;
		return daysInMonth[month-1];
	}
	
	public static boolean isLeapYear(int year)
	{
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		return false;
	}
}
