package com.atnjupt.java;

import org.junit.Test;

/**
 * @author Wizarder
 * @create 2021-07-15 14:31
 */
public class StringTest3 {
    @Test
    public void test() {
        String s = "dasd!sadsada!sadasdsad!sadasdas!dsgs";
        String[] split = s.split("\\!");
        System.out.println(split.length);
        for (String item : split) {
            System.out.println(item);
        }
    }
}
