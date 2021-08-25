package com.atnjupt.java3;

import com.atnjupt.java2.Employee;
import com.atnjupt.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * <p>
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * 3.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 * <p>
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 * <p>
 * <p>
 * 测试Stream的实例化
 *
 * @author Wizarder
 * @create 2021-03-12 21:21
 */
public class StreamAPITest {
    @Test
    //创建 Stream方式一：通过集合
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //        default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //        default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2() {
        int[] i = {123, 534, 45, 445, 67567};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(i);

        List<Employee> employees = EmployeeData.getEmployees();
        Employee[] objects = (Employee[]) employees.toArray();
        Stream<Employee> stream1 = Arrays.stream(objects);
    }

    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1231, 3213, 5646, 8);
    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test4() {

//      迭代
//      public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);


//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
