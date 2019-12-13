package com.bravo.ocp.dates;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UsingZonedId {

  public static void main(String[] args) {

    // It's the instant in UTC
    Instant now = Instant.now();
    println(now);

    ZonedDateTime nowUTCMinus1 = ZonedDateTime.ofInstant(now, ZoneId.of("UTC-1"));
    println(nowUTCMinus1);

    ZonedDateTime nowGMTPlus2 = ZonedDateTime.ofInstant(now, ZoneId.of("GMT+2"));
    println(nowGMTPlus2);

    ZonedDateTime nowSystemDefault = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
    println(nowSystemDefault);
    // Same as, it uses the system ZoneId.systemDefault()
    println(ZonedDateTime.now());

    // It is again in UTC even if nowSystemDefault is in UTC+1
    println(Instant.from(nowSystemDefault));

  }
}
