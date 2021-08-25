package com.atnjupt.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author Wizarder
 * @create 2021-03-02 16:36
 */
public class CollectionTest {
    @Test
    public void test1() {
        List coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);


        coll.forEach(System.out::println);
    }

    //练习：在List内去除重复数字值，要求尽量简单
    public List deletNumber(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        List list1 = deletNumber(list);
        for (Object o : list1) {
            System.out.println(o);
        }
    }

    @Test
    public void test3() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);

    }
}
