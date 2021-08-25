package com.atnjupt.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Wizarder
 * @create 2021-03-02 15:42
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、定制排序
    //自然排序
    //定制排序
    @Test
    public void test2() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 18);
        User u2 = new User("Jerry", 33);
        User u3 = new User("Anna", 22);
        User u4 = new User("Mike", 13);
        User u5 = new User("Mike", 23);
        map.put(u1, 66);
        map.put(u2, 87);
        map.put(u3, 90);
        map.put(u4, 89);
        map.put(u5, 100);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    @Test
    public void test1() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return -Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入数据不匹配！");
            }
        });
        User u1 = new User("Tom", 18);
        User u2 = new User("Jerry", 33);
        User u3 = new User("Anna", 22);
        User u4 = new User("Mike", 13);
        User u5 = new User("Mike", 23);
        map.put(u1, 66);
        map.put(u2, 87);
        map.put(u3, 90);
        map.put(u4, 89);
        map.put(u5, 100);
        System.out.println(map);
    }
}
