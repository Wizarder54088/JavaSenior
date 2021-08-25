package com.atnjupt.java;


import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明的方法的测试
 * <p>
 * 结论：
 * 向Collection接口的实现类的对象中移除数据obj时，要求obj所在类要重写equals().
 *
 * @author Wizarder
 * @create 2021-02-28 14:09
 */
public class CollectionTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
//        Person p = new Person("Jerry",22);
//        coll.add(p);
        coll.add(new Person("Tom", 12));
        coll.add(new String("Tom"));
        coll.add(false);
        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()。
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new Person("Tom", 12)));//false-->true

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add(123);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        //3.remove(Object obj):从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
        coll.add(new Person("Tom", 12));
        coll.add(new String("Tom"));
        coll.add(false);
        coll.remove(new Person("Tom", 12));
        System.out.println(coll);

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add("AA");
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
        coll.add(new Person("Tom", 12));
        coll.add(new String("Tom"));
        coll.add(false);
        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123);
//        coll.retainAll(coll1);
//        System.out.println(coll);
        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同,与顺序有关系。
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add(123);
        coll1.add(new Person("Tom", 12));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));//顺序不同,false。
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        coll.hashCode();

        //8.集合 --->数组：toArray()
        Object[] objects = coll.toArray();
        System.out.println(Arrays.toString(objects));

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<Integer> integers = Arrays.asList(123, 555, 6666);
        System.out.println(integers);

        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints.size());//1 存储的是int[]整体，采用上面或者下面包装类的方式解决

        List<Integer> integers1 = Arrays.asList(new Integer[]{3123, 123123});
        System.out.println(integers1);//.siz() 2

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}
