package dates_strings_localization.dates;

import java.time.*;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DatesNTimes {

    public static void main(String[] args) {
        creatingDatesAndTimes();
        manipulatingDAtesAndTimes();
        convertingToLong();
        workingWithPeriods();
    }

    private static void creatingDatesAndTimes() {
        System.out.println(LocalDate.now());
        // DateTimeException when invalid numbers in .of()
        try {
            System.out.println(LocalDate.of(2020, Month.JANUARY, 32));
        } catch (DateTimeException e) {
            System.err.println(e.getMessage());
            System.err.println(" 32 is not a valid date on January");
        }
        System.out.println("-----------------------------");
        System.out.println(LocalTime.now());
        System.out.println("-----------------------------");
        //T is used to separate date from time
        System.out.println(LocalDateTime.now());
        System.out.println("-----------------------------");
        // Adds time zone offset (+02:00)  and time zone([Europe/Paris])
        System.out.println(ZonedDateTime.now());
        System.out.println("-----------------------------");

        System.out.println(ZoneId.of("US/Eastern"));
        System.out.println(ZoneId.systemDefault());
        System.out.println("-----------------------------");
        // 3 ways of creating a ZonedDateTime to know for the exam:
        // public static ZonedDateTime of(int year, int month,
        //int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
        System.out.println("1." + ZonedDateTime.of(2019, 1, 30, 10, 10, 10, 0, ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        System.out.println("2." + ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
        System.out.println("3." + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Eastern")));
        System.out.println("-----------------------------");
        // Getting available zone Ids
        System.out.println("Available zoneIDs: " + ZoneId.getAvailableZoneIds());
        ZoneId.getAvailableZoneIds()
            .stream()
            .filter(zoneId -> zoneId.contains("America"))
            .sorted()
            .forEach(System.out::println);
        System.out.println("-----------------------------");
    }

    private static void manipulatingDAtesAndTimes() {
        // Date and Time Classes are immutable
        // this means that we need to remember to assign the results of these methods to a reference variable so that they are not lost.

        //Adding dates
        LocalDate date = LocalDate.of(2015, 1, 1);
        System.out.println(date);
        date = date.plusDays(1);
        System.out.println("plus one day: " + date);
        date = date.plusWeeks(1);
        System.out.println("plus one week: " + date);
        date = date.plusYears(1);
        System.out.println("plus one year: " + date);
        // same for go backward in time
        date = date.minusDays(10);
        System.out.println("minus 10 days: " + date);
        date = date.minusYears(10);
        System.out.println("minus 10 years: " + date);
        // Its common to chain methods
        date = date.plusYears(1).plusMonths(2).plusDays(15);
        System.out.println("Chaining methods, plus 1 year 2 months and 15 days: " + date);
        System.out.println("-----------------------------");
    }

    private static void workingWithPeriods() {
        //Period is a day or more time
        Period periodOfDays = Period.ofDays(1);
        Period periodOfYears = Period.ofYears(1);
        Period periodOfYearsMonthsAndDays = Period.of(1, 2, 3);

        // Period Format
        // it is in form P1Y1M1D:
        // P indicates is a Period
        // 1Y indicates the number of years
        // 1M indicates the number of months
        // 1D indicates the number of days
        // Java omits any measure that are zero. For example P1D or P1Y or P1Y3D
        System.out.println(periodOfDays);
        System.out.println(periodOfYears);
        System.out.println(periodOfYearsMonthsAndDays);

        // Using a Period

        LocalDate date = LocalDate.now();
        System.out.println("actual date:" + date);
        date = date.plus(periodOfYears);
        System.out.println("plus a period of one year: " + date);
        date = date.plus(periodOfDays);
        System.out.println("plus a period of one day: " + date);

        LocalTime time = LocalTime.now();
        try{
            time.plus(periodOfDays); //UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException e){
            System.out.println("time.plus(periodOfDays) throws an UnsupportedTemporalTypeException on LocalTime objects");
        }

        System.out.println("-----------------------------");
    }

    private static void convertingToLong() {
        LocalDate date = LocalDate.now();
        // Converts the date into a Long equivalent in relation to January 1th 1970. This special date is called the epoch.
        // That’s the date Unix started using for date standards

        //LocalDate has toEpochDay(), which is the number of days since January 1, 1970
        System.out.println("LocalDate.now() epoch day, days since January 1, 1970: " + date.toEpochDay());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        //LocalDateTime and ZonedDateTime have toEpochSecond(), which is the number of
        //seconds since January 1, 1970.
        System.out.println("LocalDateTime.of(LocalDate.now(), LocalTime.now()) epoch day, seconds since January 1, 1970: " + zonedDateTime.toEpochSecond());
        System.out.println("ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()) epoch day, seconds since January 1, 1970: " + dateTime.toEpochSecond(ZoneOffset.UTC));
        System.out.println("-----------------------------");

    }
}
