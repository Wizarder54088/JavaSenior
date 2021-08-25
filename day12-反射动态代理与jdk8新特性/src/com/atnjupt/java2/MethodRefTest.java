package com.atnjupt.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * <p>
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * <p>
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 * 方法引用，也是函数式接口的实例。
 * <p>
 * 3. 使用格式：  类(或对象) :: 方法名
 * <p>
 * 4. 具体分为如下的三种情况：
 * 情况1     对象 :: 非静态方法
 * 情况2     类 :: 静态方法
 * <p>
 * 情况3     类 :: 非静态方法
 * <p>
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 * 形参列表和返回值类型相同！（针对于情况1和情况2）
 * <p>
 * Created by shkstart.
 *
 * @author Wizarder
 * @create 2021-03-12 20:40
 */
public class MethodRefTest {
    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> con = str -> System.out.println(str);
        con.accept("我爱南京");
        Consumer<String> con1 = System.out::println;
        con1.accept("我爱南京");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee e = new Employee(100, "Tom", 22, 5999.2);
        Supplier<String> supplier = () -> e.getName();
        System.out.println(supplier.get());
        Supplier<String> supplier1 = e::getName;
        System.out.println(supplier1.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> con = (i, j) -> Integer.compare(i, j);
        System.out.println(con.compare(23, 66));
        Comparator<Integer> con1 = Integer::compare;
        System.out.println(con1.compare(45, 12));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> f = d -> Math.round(d);
        System.out.println(f.apply(33.4));
        Function<Double, Long> f1 = Math::round;
        System.out.println(f1.apply(33.6));
    }

    // 情况三：类 :: 实例方法  (有难度)
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test() {
        Comparator<String> com = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com.compare("aa", "ad"));
        Comparator<String> com1 = String::compareTo;
        System.out.println(com1.compare("aa", "ae"));
    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test5() {
        BiPredicate<String, String> bip = (s1, s2) -> s1.equals(s2);
        System.out.println(bip.test("aa", "bb"));
        BiPredicate<String, String> bip1 = String::equals;
        System.out.println(bip1.test("aa", "aa"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test6() {
        Employee e = new Employee(1002, "Jerry");
        Function<Employee, String> fun = (t) -> t.getName();
        System.out.println(fun.apply(e));
        Employee e1 = new Employee(1003, "Tom");
        Function<Employee, String> fun1 = Employee::getName;
        System.out.println(fun1.apply(e1));
    }

}
