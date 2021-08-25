package com.atnjupt.java3;

import com.atnjupt.java2.Employee;
import com.atnjupt.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author Wizarder
 * @create 2021-03-12 21:29
 */
public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
//        limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().limit(2).forEach(System.out::println);
        System.out.println();

//        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(5).forEach(System.out::println);
        System.out.println();
//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1006, "比尔盖茨", 99, 9500.43));
        employees.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        employees.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        employees.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
//        System.out.println(employees);
        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        //        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，
//        并将其映射成一个新的元素。
        List<String> strings = Arrays.asList("aa", "bb", "cc");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();
        //        练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().filter(e -> e.getName().length() > 3).map(e -> e.getName()).forEach(System.out::println);
        System.out.println();
        //练习2：
        Stream<Stream<Character>> listStream = strings.stream().map(StreamAPITest1::fromStringToChar);
        listStream.forEach(s -> s.forEach(System.out::println));
        System.out.println();
        //        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPITest1::fromStringToChar);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToChar(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);

    }

    //3-排序
    @Test
    public void test() {
        //        sorted()——自然排序
        List<Integer> integers = Arrays.asList(2, 6, 5, 6, 67, -2131, 9);
        integers.stream().sorted().forEach(System.out::println);

        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);


//        sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);

    }


}
