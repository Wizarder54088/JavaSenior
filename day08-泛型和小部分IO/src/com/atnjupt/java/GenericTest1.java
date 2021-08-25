package com.atnjupt.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * /** 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 * <p>
 * 1. 关于自定义泛型类、泛型接口：
 *
 * @author Wizarder
 * @create 2021-03-03 16:24
 */
public class GenericTest1 {
    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("AA");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("AA", 1001, "TT");

        order1.setOrderT("orderTT");
    }

    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderT(123);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("TT");
    }

    @Test
    public void test3() {
        ArrayList<String> list = null;
        ArrayList<Integer> list1 = null;
        //泛型不同的引用不能相互赋值。
//        list1 = list2;
        Person p1 = new Person();
        Person p2 = new Person();
        p1 = p2;
    }

    //测试泛型方法
    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> integers = Order.copyFromArrayToList(arr);
        for (Integer i : integers) {
            System.out.println(i);
        }
    }
}

