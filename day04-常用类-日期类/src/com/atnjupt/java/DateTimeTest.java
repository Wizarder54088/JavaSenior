package com.atnjupt.java;

import org.junit.Test;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Wizarder
 * @create 2021-02-23 17:24
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --->字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化
     */
    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);//21-2-23 下午5:28
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        Date date1 = sdf.parse("21-2-23 下午5:28");
        System.out.println(date1);

//*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
        //格式化
        String str1 = sdf1.format(date);
        System.out.println(str1);//2021-02-23 05:35::49
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse(str1);
        System.out.println(date2);

    }

    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

    练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3 : 打渔
    总天数 % 5 == 4,0 : 晒网

    总天数的计算？
    方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */
    @Test
    public void test2() throws ParseException {
        //练习一
//        String s = "2020-09-08";
//        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = spf.parse(s);
//        System.out.println(d);
//        java.sql.Date d2 = new java.sql.Date(d.getTime());
//        System.out.println(d2);


    }

    /*
    Calendar日历类(抽象类）的使用

     */
    @Test
    public void test3() {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar instance = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        instance.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

        //add()
        instance.add(Calendar.YEAR, 5);
        int year = instance.get(Calendar.YEAR);
        System.out.println(year);

        //getTime():日历类---> Date
        Date time = instance.getTime();
        System.out.println(time);

        //setTime():Date ---> 日历类
        Date date = new Date();
        instance.setTime(date);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

}
