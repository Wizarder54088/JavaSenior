package com.atnjupt.java2;

import com.atnjupt.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Wizarder
 * @create 2021-03-10 16:35
 */
public class OtherTest {
    /*
    获取构造器结构

     */
    @Test
    public void test() {
        Class<Person> personClass = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类

     */
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        Class superclass = personClass.getSuperclass();
        System.out.println(superclass.getName());
    }

    /*
        获取运行时类的带泛型的父类

         */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());
    }

    /*
   获取运行时类的带泛型的父类的泛型
    需要掌握

   代码：逻辑性代码  vs 功能性代码
    */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//         System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /*
   获取运行时类实现的接口
    */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        Class[] interfaces = personClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }
        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c.getName());
        }
    }

    /*
     获取运行时类所在的包

  */
    @Test
    public void test5() {
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    /*
        获取运行时类声明的注解

     */
    @Test
    public void test7() {
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos : annotations) {
            System.out.println(annos);
        }
    }
}

