package com.bravo.ocp.dates;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.time.Duration;
import java.time.Period;

public class DurationNPeriod {

  public static void main(String[] args) {

    // Duration format PT1H1M1S

    println("Duration of 25 hours: {}", Duration.ofHours(25));
    // Duration format will always transform days to hours, so Duration.ofDays(2) = PT48H
    println("Duration of 1 day and 1 hour: {}", Duration.ofDays(2));
    println("Duration of 100000 seconds: {}", Duration.ofSeconds(100000));
    println("Duration of 1 days + 1 hour + 30 minutes + 30 seconds: {}", Duration.ofDays(1).plusHours(1).plusMinutes(30).plusSeconds(30));


    // Period format P1Y1M1D
    println("Period of 1 year : {}", Period.ofYears(1));
    println("Period of 2 days : {}", Period.ofDays(2));
    println("Period of 13 Months : {}", Period.ofMonths(13));
    println("Period of 1 year + 13 Months + 31 days : {}", Period.ofYears(1).plusMonths(13).plusDays(31));

  }

}
