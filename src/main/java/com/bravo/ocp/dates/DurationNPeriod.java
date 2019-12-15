package com.bravo.ocp.dates;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.time.Duration;
import java.time.Period;

public class DurationNPeriod {

  public static void main(String[] args) {

    // Duration format PT1H1M1S

    println("Duration of 25 hours: {}", Duration.ofHours(25));
    // Duration format will always transform days to hours, so Duration.ofDays(2) = PT48H
    println("Duration of 2 days: {}", Duration.ofDays(2));
    println("Duration of 100000 seconds: {}", Duration.ofSeconds(100000));
    println("Duration of 1 days + 1 hour + 30 minutes + 30 seconds: {}", Duration.ofDays(1).plusHours(1).plusMinutes(30).plusSeconds(30));
    println("Duration of 0 will always be in Segs: {}", Duration.ofDays(0));

    println("Duration of 61 secs: {}", Duration.ofSeconds(61));
    println("Duration of 61 mins: {}", Duration.ofMinutes(61));

    // Period format P1Y1M1D
    println("Period of 1 year : {}", Period.ofYears(1));
    println("Period of 2 days : {}", Period.ofDays(2));
    println("Period of 13 Months : {}", Period.ofMonths(13));
    println("Period of 32 days : {}", Period.ofDays(32));
    println("Period of 1 year + 13 Months + 31 days : {}", Period.ofYears(1).plusMonths(13).plusDays(31));
    println("Period of 0 will always be in Days: {}", Period.ofYears(0));

  }

}
