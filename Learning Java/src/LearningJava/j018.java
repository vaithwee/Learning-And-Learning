package LearningJava;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Vaith on 16/8/2.
 */
public class j018 {
    public static void main(String[] args)
    {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int year;
        GregorianCalendar gcalendar = new GregorianCalendar();
        System.out.print("Date:");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time:");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.print(gcalendar.get(Calendar.SECOND));

        if (gcalendar.isLeapYear(year))
        {
            System.out.println("当前年份是润年");
        }
        else
        {
            System.out.println("当前年份不是闰年");
        }
    }
}
