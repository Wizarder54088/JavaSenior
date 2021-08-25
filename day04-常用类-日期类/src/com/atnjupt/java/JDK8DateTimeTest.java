package com.atnjupt.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author Wizarder
 * @create 2021-02-23 18:01
 */
public class JDK8DateTimeTest {

    @Test
    public void test1() {
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
   说明：
   1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
   2.类似于Calendar
*/
    @Test
    public void test2() {
        //now():获取当前的日期、时间、日期+时间
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 5, 13, 21, 44, 55);
        System.out.println(localDateTime1);

        //getXxx()：获取相关的属性
        System.out.println(localDate.getMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());
        //体现不可变性
        //withXxx():设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(8);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //不可变性 plusXxx添加  minusXxx减少
        LocalDate localDate1 = localDate.plusDays(33);
        System.out.println(localDate);
        System.out.println(localDate1);
        LocalDate localDate2 = localDate.minusMonths(1);
        System.out.println(localDate);
        System.out.println(localDate2);
    }

    /*
     Instant的使用
    类似于 java.util.Date类

     */
    @Test
    public void test3() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//now():获取本初子午线对应的标准时间

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1614076122547L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */
    @Test
    public void test4() {
        //        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME

        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = dtf.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);

        //解析：字符串 -->日期
        TemporalAccessor parse = dtf.parse(format);
        System.out.println(parse);

        //        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化
        String format1 = dtf1.format(localDateTime);
        System.out.println(format1);


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String format2 = dtf2.format(LocalDate.now());
        System.out.println(format2);

        //       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dft3 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh-mm-ss");
        //格式化
        System.out.println(dft3.format(LocalDateTime.now()));


        TemporalAccessor parse1 = dft3.parse(dft3.format(LocalDateTime.now()));
        System.out.println(parse1);

    }
}
