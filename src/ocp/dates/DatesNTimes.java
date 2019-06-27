package ocp.dates;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import static ocp.utils.CommonUtils.printLn;

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
        printLn(LocalDate.now());
        // DateTimeException when invalid numbers in .of()
        try {
            printLn(LocalDate.of(2020, Month.JANUARY, 32));
        } catch (DateTimeException e) {
            System.err.println(e.getMessage());
            System.err.println(" 32 is not a valid date on January");
        }
        printLn("-----------------------------");
        printLn(LocalTime.now());
        printLn("-----------------------------");
        //T is used to separate date from time
        printLn(LocalDateTime.now());
        printLn("-----------------------------");
        // Adds time zone offset (+02:00)  and time zone([Europe/Paris])
        printLn(ZonedDateTime.now());
        printLn("-----------------------------");

        printLn(ZoneId.of("US/Eastern"));
        printLn(ZoneId.systemDefault());
        printLn("-----------------------------");
        // 3 ways of creating a ZonedDateTime to know for the exam:
        // public static ZonedDateTime of(int year, int month,
        //int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
        printLn("1.{}", ZonedDateTime.of(2019, 1, 30, 10, 10, 10, 0, ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        printLn("2.{}", ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("US/Eastern")));
        // public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
        printLn("3.{}", ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Eastern")));
        printLn("-----------------------------");
        // Getting available zone Ids
        printLn("Available zoneIDs: {}", ZoneId.getAvailableZoneIds());
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zoneId -> zoneId.contains("America"))
                .sorted()
                .forEach(System.out::println);
        printLn("-----------------------------");
    }

    private static void manipulatingDAtesAndTimes() {
        // Date and Time Classes are immutable
        // this means that we need to remember to assign the results of these methods to a reference variable so that they are not lost.

        //Adding dates
        LocalDate date = LocalDate.of(2015, 1, 1);
        printLn(date);
        date = date.plusDays(1);
        printLn("plus one day: {}", date);
        date = date.plusWeeks(1);
        printLn("plus one week: {}", date);
        date = date.plusYears(1);
        printLn("plus one year: {}", date);
        // same for go backward in time
        date = date.minusDays(10);
        printLn("minus 10 days: {}", date);
        date = date.minusYears(10);
        printLn("minus 10 years: {}", date);
        // Its common to chain methods
        date = date.plusYears(1).plusMonths(2).plusDays(15);
        printLn("Chaining methods, plus 1 year 2 months and 15 days: {}", date);
        printLn("-----------------------------");
    }

    private static void convertingToLong() {
        LocalDate date = LocalDate.now();
        // Converts the date into a Long equivalent in relation to January 1th 1970. This special date is called the epoch.
        // That’s the date Unix started using for date standards

        //LocalDate has toEpochDay(), which is the number of days since January 1, 1970
        printLn("LocalDate.now() epoch day, days since January 1, 1970: {}", date.toEpochDay());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        //LocalDateTime and ZonedDateTime have toEpochSecond(), which is the number of
        //seconds since January 1, 1970.
        printLn("LocalDateTime.of(LocalDate.now(), LocalTime.now()) epoch day, seconds since January 1, 1970: {}", zonedDateTime.toEpochSecond());
        printLn("ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()) epoch day, seconds since January 1, 1970: {}", dateTime.toEpochSecond(ZoneOffset.UTC));
        printLn("-----------------------------");

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
        printLn(periodOfDays);
        printLn(periodOfYears);
        printLn(periodOfYearsMonthsAndDays);

        // Using a Period

        LocalDate date = LocalDate.now();
        printLn("actual date:{}", date);
        date = date.plus(periodOfYears);
        printLn("plus a period of one year: {}", date);
        date = date.plus(periodOfDays);
        printLn("plus a period of one day: {}", date);

        LocalTime time = LocalTime.now();
        try {
            time.plus(periodOfDays); //UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException e) {
            printLn("time.plus(periodOfDays) throws an UnsupportedTemporalTypeException on LocalTime objects");
        }

        printLn("-----------------------------");
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
        printLn("Duration format ofHours(): {}", duration);
        printLn("Duration format: ofSeconds(){}", everySeconds);
        // The number of seconds includes fractional seconds
        printLn("Duration format: ofNanos(){}", everyNanos);

        // Create Duration with ChronoUnit
        Duration everyHours = Duration.of(10, ChronoUnit.HOURS);

        //Using Duration

        LocalTime now = LocalTime.now();
        printLn("now time: {}", now);
        printLn("now plus one hour: {}", now.plus(hourly));

        LocalDateTime nowDateTime = LocalDateTime.now();
        printLn("now date time: {}", nowDateTime);
        printLn("now date time: plus one hour {}", nowDateTime.plus(hourly));

        // Duration cannot be used with LocalDate since it doesn't manage hours, minutes or seconds
        // UnsupportedTemporalException will be thrown
        try {
            LocalDate.now().plus(hourly);
        } catch (UnsupportedTemporalTypeException e) {
            printLn("UnsupportedTemporalException is thrown when Duration is used with LocalDate: Unsupported unit secods ");
        }

        printLn("ChronoUnit for differences:");
        printLn("difference in Hours between {} and {} : {}", now, now.plus(hourly), ChronoUnit.HOURS.between(now, now.plus(hourly)));
        printLn("difference in minutes between {} and {} : {}", now, " and ", now.plus(hourly), ChronoUnit.MINUTES.between(now, now.plus(hourly)));
        printLn("difference in seconds between {} and {} : {}", now, now.plus(hourly), ChronoUnit.SECONDS.between(now, now.plus(hourly)));
        printLn("-----------------------------");
    }

    private static void workingWithInstants() {
        printLn("Working with Instants....");
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
        printLn("Time difference: {} millis", ChronoUnit.MILLIS.between(now, later));

        // We can create an Instant from the number of seconds since 1970
        Instant fromEpochSeconds = Instant.ofEpochSecond(ZonedDateTime.now().toEpochSecond());
        printLn("Instant from epoch seconds: {}", fromEpochSeconds);

        // We can do math using Instant. Instant allows you to add any unit day or smaller
        Instant nextDay = now.plus(1, ChronoUnit.DAYS);
        printLn("Instant math:");
        printLn("next day {}", nextDay);
        Instant nextMinute = now.plus(1, ChronoUnit.MINUTES);
        printLn("next day {}", nextMinute);
        // Instant displays a Year and Month while preventing you from doing math with them. You need to memorize it.
        try {
            now.plus(1, ChronoUnit.MONTHS);  // UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException e) {
            printLn("now.plus(1, ChronoUnit.MONTHS) will throw {} - {}", e.getClass(), e.getMessage());
        }

        printLn("-----------------------------");

    }
}
