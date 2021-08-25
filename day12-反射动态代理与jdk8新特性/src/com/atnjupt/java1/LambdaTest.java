package com.atnjupt.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 *
 * @author Wizarder
 * @create 2021-03-12 19:10
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();
        Runnable r2 = () -> {
            System.out.println("我爱印度");
        };
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare("abc", "abd"));
        System.out.println();
        //Lambda表达式的写法
        Comparator<String> com1 = (s1, s2) -> {
            return s1.compareTo(s2);
        };
        System.out.println(com1.compare("abe", "abc"));
        System.out.println("***********************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(42, 66));
    }
}
