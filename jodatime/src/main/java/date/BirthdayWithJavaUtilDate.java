package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public final class BirthdayWithJavaUtilDate implements BirthdayCalculator<Date> {

    @Override
    public Date parseDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String printMonthAndDay(Date date) {
        // TODO - return the date formatted: month & day (MM. dd.)
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.' 'dd.");

        return dateFormat.format(date);
    }

    @Override
    public boolean isAnniversaryToday(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String today = printMonthAndDay(gregorianCalendar.getTime());
        return printMonthAndDay(date).equals(today);
    }

    @Override
    public int calculateAgeInYears(Date birthday) {
        Calendar todayCal = GregorianCalendar.getInstance();
        Calendar birthCal = new GregorianCalendar();
        birthCal.setTime(birthday);
        int thisYear = todayCal.getTime().getYear();
        int birthYear = birthday.getYear();
        if (thisYear > birthYear) {
            if ((todayCal.get(Calendar.DAY_OF_YEAR) > birthCal.get(Calendar.DAY_OF_YEAR))) {
                return thisYear - birthYear;
            } else return thisYear - birthYear - 1;
        } else return 0;
    }

    @Override
    public int calculateDaysToNextAnniversary(Date input) {
        GregorianCalendar todayCal = new GregorianCalendar();
        GregorianCalendar inputCal = new GregorianCalendar();
        inputCal.setTime(input);
        int inputDayNr = inputCal.get(Calendar.DAY_OF_YEAR);
        int todayDayNr = todayCal.get(Calendar.DAY_OF_YEAR);
        Date todayDate = todayCal.getTime();
        Date inputDate = inputCal.getTime();
        int numberOfDaysThisYear = todayCal.getActualMaximum(Calendar.DAY_OF_YEAR);
        int numberOfDaysInInputYear = inputCal.getActualMaximum(Calendar.DAY_OF_YEAR);
        if (numberOfDaysInInputYear - 366 + inputDayNr >= numberOfDaysThisYear - 366 + todayDayNr) {
            todayDate.setYear(inputDate.getYear() + 1);
            todayDayNr = todayCal.get(Calendar.DAY_OF_YEAR);
            System.out.println("inside if");
            return numberOfDaysThisYear - inputDayNr + todayDayNr;
        } else {
            return (todayDayNr - inputDayNr);
        }
    }

    public static void main(String[] args) {
        new BirthdayWithJavaUtilDate().run();
    }

    private void run() {
        while (true) {
            print("Birthday with java.util.Date.");
            String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

            Date birthdayDate = parseDate(birthdayStr);
            print("Your birthday: " + printMonthAndDay(birthdayDate));

            if (false/*isAnniversaryToday(birthdayDate)*/) {
                int ageInYears = calculateAgeInYears(birthdayDate);
                print("Congratulations! Today is your " + ageInYears + "th birthday!");
            } else {
                int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
                print("You have to wait only " + daysLeft + " days for your next birthday.");
            }
        }
    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");

}
