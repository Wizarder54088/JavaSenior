package com.atnjupt.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author Wizarder
 * @create 2021-02-25 15:02
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 winter = Season1.WINTER;
        //toString():返回枚举类对象的名称
        System.out.println(winter.toString());

//        System.out.println(winter.getClass().getSuperclass());//父类是Enum类
        System.out.println("****************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        System.out.println("****************");
        Season1 autume = Season1.valueOf("AUTUME");
        System.out.println(autume.toString());
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        Season1 spring = Season1.SPRING;
        spring.show();
        winter.show();
    }
}

interface Infor {
    void show();
}

//使用enum关键字枚举类
enum Season1 implements Infor {
    SPRING("春天", "春意盎然") {
        @Override
        public void show() {
            System.out.println("s1 - " + getSeasonName());
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("s2 - " + getSeasonName());
        }
    },
    AUTUME("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("s3 - " + getSeasonName());
        }
    },
    WINTER("冬天", "白雪皑皑") {
        @Override
        public void show() {
            System.out.println("s4 - " + getSeasonName());
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seansonDec;

    //2.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName, String seansonDec) {
        this.seasonName = seasonName;
        this.seansonDec = seansonDec;
    }
    //4.其他诉求1：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeansonDec() {
        return seansonDec;
    }

//    @Override
//    public void show() {
//        System.out.println("hello,i am a season "+getSeasonName());
//    }
    //4.其他诉求1：提供toString()

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seansonDec='" + seansonDec + '\'' +
//                '}';
//    }
}