package com.atnjupt.exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * <p>
 * 1). 使Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 *
 * @author Wizarder
 * @create 2021-03-02 17:01
 */
public class EmployeeTest {
    //问题一：使用自然排序
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        Employee e1 = new Employee("liudehua", 33, new MyDate(1997, 3, 15));
        Employee e2 = new Employee("zhangjiahui", 22, new MyDate(1987, 4, 5));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1977, 5, 3));
        Employee e4 = new Employee("liming", 55, new MyDate(1967, 6, 2));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        System.out.println(treeSet);
    }

    @Test
    public void test2() {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //比较年

                    if (b1.getYear() != b2.getYear()) {
                        return Integer.compare(b1.getYear(), b2.getYear());
                    }
                    //比较月
                    if (b1.getMonth() != b2.getMonth()) {
                        return Integer.compare(b1.getMonth(), b2.getMonth());
                    }
                    //比较日
                    return Integer.compare(b1.getDay(), b2.getDay());

//                    return b1.compareTo(b2);


                    //方式一：
//////                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if(minusYear != 0){
//                        return minusYear;
//                    }
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if(minusMonth != 0){
//                        return minusMonth;
//                    }
//                    //比较日
//                    return b1.getDay() - b2.getDay();

                }
                throw new RuntimeException("输入数据不匹配！");
            }
        });
        Employee e1 = new Employee("liudehua", 33, new MyDate(1997, 3, 15));
        Employee e2 = new Employee("zhangjiahui", 22, new MyDate(1987, 4, 5));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1967, 6, 12));
        Employee e4 = new Employee("liming", 55, new MyDate(1967, 6, 2));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
