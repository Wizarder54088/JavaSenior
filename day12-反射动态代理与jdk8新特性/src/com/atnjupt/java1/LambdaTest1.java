package com.atnjupt.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * <p>
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 * -> :lambda操作符 或 箭头操作符
 * ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 * ->右边：lambda体 （其实就是重写的抽象方法的方法体）
 * <p>
 * 3. Lambda表达式的使用：（分为6种情况介绍）
 * <p>
 * 总结：
 * ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 * ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 * <p>
 * 4.Lambda表达式的本质：作为函数式接口的实例
 * <p>
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，
 * 这样做可以检查它是否是一个函数式接口。
 * <p>
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 * @author Wizarder
 * @create 2021-03-12 19:29
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();
        System.out.println("***********************");
        Runnable r2 = () -> System.out.println("我爱印度");
        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test2() {
        Consumer<String> con = (String s) -> System.out.println(s);
        con.accept("一个是听得人当真了，一个是说的人当真了");
    }

    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<>();//类型推断

        int[] arr = {1, 2, 3};//类型推断
    }

    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听得人当真了，一个是说的人当真了");
        System.out.println("*******************");
        Consumer<String> con2 = s -> System.out.println(s);
        con1.accept("一个是听得人当真了，一个是说的人当真了");

    }

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com.compare(33, 77));

        Comparator<Integer> com1 = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
            return Integer.compare(s1, s2);
        };
        System.out.println(com1.compare(234, 55));
    }

    @Test
    public void test6() {

        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("一个是听得人当真了，一个是说的人当真了");

        System.out.println("*****************************");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("一个是听得人当真了，一个是说的人当真了");
    }
}
