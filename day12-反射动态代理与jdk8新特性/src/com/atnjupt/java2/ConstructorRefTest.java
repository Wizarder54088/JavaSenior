package com.atnjupt.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 * 抽象方法的返回值类型即为构造器所属的类的类型
 * <p>
 * 二、数组引用
 * 大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 * <p>
 * Created by shkstart
 *
 * @author Wizarder
 * @create 2021-03-12 21:09
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1() {
        Supplier<Employee> s = () -> new Employee();
        System.out.println(s.get());
        Supplier<Employee> s1 = Employee::new;
        System.out.println(s1.get());
    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer, Employee> s = id -> new Employee(id);
        System.out.println(s.apply(1001));
        Function<Integer, Employee> s1 = Employee::new;
        System.out.println(s1.apply(1002));
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> bi = (id, name) -> new Employee(id, name);
        System.out.println(bi.apply(1001, "Tom"));
        BiFunction<Integer, String, Employee> bi1 = Employee::new;
        System.out.println(bi1.apply(1002, "Jerry"));
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> function = i -> new String[i];
        System.out.println(Arrays.toString(function.apply(10)));
        Function<Integer, String[]> function1 = String[]::new;
        System.out.println(Arrays.toString(function1.apply(5)));

    }
}
