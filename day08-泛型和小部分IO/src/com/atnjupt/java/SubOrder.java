package com.atnjupt.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wizarder
 * @create 2021-03-03 16:43
 */
public class SubOrder extends Order<Integer> {

    public static <E> List<E> copyFromArrayToList(E[] arr) {

        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
