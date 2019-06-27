package ocp.dates;

import ocp.utils.CommonUtils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import static ocp.utils.CommonUtils.println;

public class DatesNTimes {

    public static void main(String[] args) {
        creatingDatesAndTimes();
        manipulatingDAtesAndTimes();
        convertingToLong();
        workingWithPeriods();
        workingWithDuration();
        workingWithInstants();
    }

    private static void creatingDatesAndTimes() {
        CommonUtils.println(LocalDate.now());
        // DateTimeException when invalid numbers in .of()
        try {
            CommonUtils.println(LocalDate.of(2020, Month.JANUARY, 32));
        } catch (DateTimeException e) {
            System.err.println(e.getMessage());
            System.err.println(" 32 is not a valid date on January");
        }
        CommonUtils.println("-----------------------------");
        CommonUtils.println(LocalTime.now());
        CommonUtils.println("-----------------------------");
        //T is used to separate date from time
        CommonUtils.println(LocalDateTime.now());
        CommonUtils.println("-----------------------------");
        // Adds time zone offset (+02:00)  and time zone([Europe/Paris])
        CommonUtils.println(ZonedDateTime.now());
        CommonUtils.println("-----------------------------");

        CommonUtils.println(ZoneId.of("US/Eastern"));
        CommonUtils.println(ZoneId.systemDefault());
        CommonUtils.println("-----------------------------");
        // 3 ways of creating a ZonedDateTime to know for the exam:
        // public static ZonedDateTime of(int year, int month,
        //int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
        println("1.{}", ZonedDateTime.of(2019, 1, 30, 10, 10, 10, 0, ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        println("2.{}", ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
        println("3.{}", ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Eastern")));
        CommonUtils.println("-----------------------------");
        // Getting available zone Ids
        println("Available zoneIDs: {}", ZoneId.getAvailableZoneIds());
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zoneId -> zoneId.contains("America"))
                .sorted()
                .forEach(System.out::println);
        CommonUtils.println("-----------------------------");
    }

    private static void manipulatingDAtesAndTimes() {
        // Date and Time Classes are immutable
        // this means that we need to remember to assign the results of these methods to a reference variable so that they are not lost.

        //Adding dates
        LocalDate date = LocalDate.of(2015, 1, 1);
        CommonUtils.println(date);
        date = date.plusDays(1);
        println("plus one day: {}", date);
        date = date.plusWeeks(1);
        println("plus one week: {}", date);
        date = date.plusYears(1);
        println("plus one year: {}", date);
        // same for go backward in time
        date = date.minusDays(10);
        println("minus 10 days: {}", date);
        date = date.minusYears(10);
        println("minus 10 years: {}", date);
        // Its common to chain methods
        date = date.plusYears(1).plusMonths(2).plusDays(15);
        println("Chaining methods, plus 1 year 2 months and 15 days: {}", date);
        CommonUtils.println("-----------------------------");
    }

    private static void convertingToLong() {
        LocalDate date = LocalDate.now();
        // Converts the date into a Long equivalent in relation to January 1th 1970. This special date is called the epoch.
        // That’s the date Unix started using for date standards

        //LocalDate has toEpochDay(), which is the number of days since January 1, 1970
        println("LocalDate.now() epoch day, days since January 1, 1970: {}", date.toEpochDay());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        //LocalDateTime and ZonedDateTime have toEpochSecond(), which is the number of
        //seconds since January 1, 1970.
        println("LocalDateTime.of(LocalDate.now(), LocalTime.now()) epoch day, seconds since January 1, 1970: {}", zonedDateTime.toEpochSecond());
        println("ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()) epoch day, seconds since January 1, 1970: {}", dateTime.toEpochSecond(ZoneOffset.UTC));
        CommonUtils.println("-----------------------------");

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
        CommonUtils.println(periodOfDays);
        CommonUtils.println(periodOfYears);
        CommonUtils.println(periodOfYearsMonthsAndDays);

        // Using a Period

        LocalDate date = LocalDate.now();
        println("actual date:{}", date);
        date = date.plus(periodOfYears);
        println("plus a period of one year: {}", date);
        date = date.plus(periodOfDays);
        println("plus a period of one day: {}", date);

        LocalTime time = LocalTime.now();
        try {
            time.plus(periodOfDays); //UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException e) {
            CommonUtils.println("time.plus(periodOfDays) throws an UnsupportedTemporalTypeException on LocalTime objects");
        }

        CommonUtils.println("-----------------------------");
    }

    private static void workingWithDuration() {
        // Work as Period but it is intended for smaller units of time.
        // You can specify number of days, hours, minutes, seconds or nanoseconds.
        // And it is used in objects that have time


        // Format PT1H1M1S:
        // Period of time
        // Hours
        // Minutes
        // Seconds
        Duration duration = Duration.ofHours(60);
        Duration hourly = Duration.ofHours(1);
        Duration everySeconds = Duration.ofSeconds(360);
        Duration everyNanos = Duration.ofNanos(36000);
        println("Duration format ofHours(): {}", duration);
        println("Duration format: ofSeconds(){}", everySeconds);
        // The number of seconds includes fractional seconds
        println("Duration format: ofNanos(){}", everyNanos);

        // Create Duration with ChronoUnit
        Duration everyHours = Duration.of(10, ChronoUnit.HOURS);

        //Using Duration

        LocalTime now = LocalTime.now();
        println("now time: {}", now);
        println("now plus one hour: {}", now.plus(hourly));

        LocalDateTime nowDateTime = LocalDateTime.now();
        println("now date time: {}", nowDateTime);
        println("now date time: plus one hour {}", nowDateTime.plus(hourly));

        // Duration cannot be used with LocalDate since it doesn't manage hours, minutes or seconds
        // UnsupportedTemporalException will be thrown
        try {
            LocalDate.now().plus(hourly);
        } catch (UnsupportedTemporalTypeException e) {
            CommonUtils.println("UnsupportedTemporalException is thrown when Duration is used with LocalDate: Unsupported unit secods ");
        }

        CommonUtils.println("ChronoUnit for differences:");
        println("difference in Hours between {} and {} : {}", now, now.plus(hourly), ChronoUnit.HOURS.between(now, now.plus(hourly)));
        println("difference in minutes between {} and {} : {}", now, " and ", now.plus(hourly), ChronoUnit.MINUTES.between(now, now.plus(hourly)));
        println("difference in seconds between {} and {} : {}", now, now.plus(hourly), ChronoUnit.SECONDS.between(now, now.plus(hourly)));
        CommonUtils.println("-----------------------------");
    }

    private static void workingWithInstants() {
        CommonUtils.println("Working with Instants....");
        // Instant represents a specific moment in time in the GMT time zone
        // It could be used to run a Timer
        Instant now = Instant.now();
        // ... Something time consuming
        try {
            Thread.sleep(Duration.ofSeconds(2).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant later = Instant.now();
        println("Time difference: {} millis", ChronoUnit.MILLIS.between(now, later));

        // We can create an Instant from the number of seconds since 1970
        Instant fromEpochSeconds = Instant.ofEpochSecond(ZonedDateTime.now().toEpochSecond());
        println("Instant from epoch seconds: {}", fromEpochSeconds);

        // We can do math using Instant. Instant allows you to add any unit day or smaller
        Instant nextDay = now.plus(1, ChronoUnit.DAYS);
        CommonUtils.println("Instant math:");
        println("next day {}", nextDay);
        Instant nextMinute = now.plus(1, ChronoUnit.MINUTES);
        println("next day {}", nextMinute);
        // Instant displays a Year and Month while preventing you from doing math with them. You need to memorize it.
        try {
            now.plus(1, ChronoUnit.MONTHS);  // UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException e) {
            println("now.plus(1, ChronoUnit.MONTHS) will throw {} - {}", e.getClass(), e.getMessage());
        }

        CommonUtils.println("-----------------------------");

    }
}
