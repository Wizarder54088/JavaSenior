package com.atnjupt.java3;

import com.atnjupt.java2.Employee;
import com.atnjupt.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author Wizarder
 * @create 2021-03-12 22:27
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test() {
        List<Employee> employees = EmployeeData.getEmployees();
        //        allMatch(Predicate p)——检查是否匹配所有元素。
//          练习：是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //        anyMatch(Predicate p)——检查是否至少匹配一个元素。
//         练习：是否存在员工的工资大于 10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //        noneMatch(Predicate p)——检查是否没有可以匹配的元素。意思是不包含这个元素，如不包含姓为“雷”的员工。
//          练习：是否存在员工姓“雷”
        boolean b3 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b3);

        //        findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //        findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    //计数、遍历、与大小
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //count() 返回一个long类型的数，表示总和
        long count = employees.stream().filter(e -> e.getSalary() > 6000).count();
        System.out.println(count);
        //        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资：
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max);
        //        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println();
        //        forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
    }

    //2-归约
    @Test
    public void test3() {
        //        reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
//        练习1：计算1-10的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //        reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1.get());

    }

    //3-收集
    @Test
    public void test4() {
        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
//练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        System.out.println();
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.stream().forEach(System.out::println);
    }
}
