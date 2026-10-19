import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class display_system_datetime
{
public static void main(String[] args)
{

	Date date = new Date();
	Calendar cal = Calendar.getInstance();

	
	SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("Current date is " + f1.format(date));

	SimpleDateFormat f2 = new SimpleDateFormat("dd-MM-yyyy");
	System.out.println("Current date is " + f2.format(date));

	SimpleDateFormat f3 = new SimpleDateFormat("EEEE MMMM dd yyyy");
	System.out.println("Current date is " + f3.format(date));

	SimpleDateFormat f4 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	System.out.println("Current date and time is " + f4.format(date));

	SimpleDateFormat f5 = new SimpleDateFormat("dd/MM/yy HH:mm:ss a z");
	System.out.println("Current date and time is " + f5.format(date));

	
	System.out.println("Current week of year is: " + cal.get(Calendar.WEEK_OF_YEAR));
	System.out.println("Current week of month is: " + cal.get(Calendar.WEEK_OF_MONTH));
	System.out.println("Current day of year is: " + cal.get(Calendar.DAY_OF_YEAR));

}
}
