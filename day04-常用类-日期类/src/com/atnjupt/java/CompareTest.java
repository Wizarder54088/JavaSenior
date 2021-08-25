package com.atnjupt.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 * 如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 * <p>
 * 二、Comparable接口与Comparator的使用的对比：
 * Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 * Comparator接口属于临时性的比较。
 *
 * @author Wizarder
 * @create 2021-02-23 20:54
 */
public class CompareTest {
    /*
   Comparable接口的使用举例：  自然排序
   1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
   2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
   3. 重写compareTo(obj)的规则：
       如果当前对象this大于形参对象obj，则返回正整数，
       如果当前对象this小于形参对象obj，则返回负整数，
       如果当前对象this等于形参对象obj，则返回零。
   4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
      在compareTo(obj)方法中指明如何排序
    */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods(35, "lenovoMouse");
        arr[1] = new Goods(22, "xiaomiMouse");
        arr[2] = new Goods(55, "sansungMous");
        arr[3] = new Goods(48, "huaweiMous");
        arr[4] = new Goods(63, "dellMous");

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods(35, "lenovoMouse");
        arr[1] = new Goods(22, "xiaomiMouse");
        arr[2] = new Goods(55, "sansungMous");
        arr[3] = new Goods(48, "huaweiMous");
        arr[4] = new Goods(63, "dellMous");
        arr[5] = new Goods(22, "microsoftMous");

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
Comparator接口的使用：定制排序
1.背景：
当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
那么可以考虑使用 Comparator 的对象来排序
2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
如果方法返回正整数，则表示o1大于o2；
如果返回0，表示相等；
返回负整数，表示o1小于o2。

*/
    @Test
    public void test4() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s = (String) o1;
                    String s1 = (String) o2;
                    return -s.compareTo(s1);
                }
                throw new RuntimeException("类型不匹配！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test5() {
        Goods[] arr = new Goods[7];
        arr[0] = new Goods(35, "lenovoMouse");
        arr[1] = new Goods(22, "xiaomiMouse");
        arr[2] = new Goods(55, "sansungMous");
        arr[3] = new Goods(48, "huaweiMous");
        arr[4] = new Goods(63, "dellMous");
        arr[5] = new Goods(22, "microsoftMous");
        arr[6] = new Goods(323, "xiaomiMouse");
        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods s1 = (Goods) o1;
                    Goods s2 = (Goods) o2;
                    if (s1.getName() == s2.getName()) {
                        return -Double.compare(s1.getPrice(), s2.getPrice());
                    } else {
                        return s1.getName().compareTo(s2.getName());
                    }
                }
                throw new RuntimeException("输入数据不匹配");
            }

        });
        System.out.println(Arrays.toString(arr));
    }
}
