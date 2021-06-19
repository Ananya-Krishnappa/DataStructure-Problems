/**
 * Purpose:To create a calendar using 2d array
 * @author Ananya K
 * @version 1.0
 * @since 15/06/2021
 * 
 */
package bridgelabz.DataStructure_Problems;

import java.time.LocalDate;

public class Calendar {
	private int firstday = 1;
	private int mycalendar[][] = new int[6][7];

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		String nameOfTheWeeks = "Mon\t" + "Tue\t" + "Wed\t" + "Thu\t" + "Fri\t" + "Sat\t" + "Sun\t";
		System.out.println(nameOfTheWeeks);
		cal.createCalendar();
	}

	/**
	 * This method initializes a calendar and prints the calendar.
	 */
	private void createCalendar() {
		int lengthOfMonth = LocalDate.now().lengthOfMonth();
		int firstDayOfMonthsWeekDay = LocalDate.now().withDayOfMonth(1).getDayOfWeek().getValue();

		// use a labeled break statement to terminate the outer for loop when we reach
		// the end of the month
		month: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (--firstDayOfMonthsWeekDay > 0) {
					continue;
				}
				mycalendar[i][j] = firstday++;
				if (firstday > lengthOfMonth) {
					break month; // the execution will continue after the outer loop
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print((mycalendar[i][j] == 0 ? " " : mycalendar[i][j]) + "\t");
				if (j == 6) {
					System.out.println();
				}
			}
		}
	}
}
