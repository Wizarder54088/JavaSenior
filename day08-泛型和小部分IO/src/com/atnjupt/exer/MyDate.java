package com.atnjupt.exer;

/**
 * MyDate类包含:
 * private成员变量year,month,day；并为每一个属性定义 getter, setter 方法；
 *
 * @author Wizarder
 * @create 2021-03-02 16:57
 */
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate m) {


        //比较年

        if (this.getYear() != m.getYear()) {
            return Integer.compare(this.getYear(), m.getYear());
        }
        //比较月
        if (this.getMonth() != m.getMonth()) {
            return Integer.compare(this.getMonth(), m.getMonth());
        }
        //比较日
        return Integer.compare(this.getDay(), m.getDay());


    }
}
