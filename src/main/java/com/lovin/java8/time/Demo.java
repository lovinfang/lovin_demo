/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @version $Id: Demo.java, v 0.1 2019年02月15日 17:31 lovin Exp $
 */
public class Demo {

    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock );


    }
}