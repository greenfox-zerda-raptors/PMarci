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
            Date parsedDate = dateFormat.parse(str);
            return parsedDate;
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
        // TODO - return how many years age the input date 'birthday' was
        if (thisYear > birthYear) {
            if ((todayCal.get(Calendar.DAY_OF_YEAR) > birthCal.get(Calendar.DAY_OF_YEAR))) {
                return thisYear - birthYear;
            } else return thisYear - birthYear - 1;
        } else return 0;
    }

    @Override
    public int calculateDaysToNextAnniversary(Date date) {
        Calendar todayCal = Calendar.getInstance();
        Calendar dateCal = new GregorianCalendar();
        dateCal.setTime(date);
        System.out.println(dateCal.compareTo(todayCal));

        // TODO - the number of days remaining to the next anniversary of 'date' (e.g. if tomorrow, return 1)
        return -1;
    }

    public static void main(String[] args) {
        new BirthdayWithJavaUtilDate().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        Date birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
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
