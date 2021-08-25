package com.atnjupt.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 * 动态代理：根据被代理类的不同，创建对应的代理类，去执行对应被代理的功能。
 *
 * @author Wizarder
 * @create 2021-03-12 17:12
 */
public class ProxyTest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        proxyInstance.believe();
        System.out.println();
        proxyInstance.eat("菠菜");
        System.out.println("*****************************");
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();

    }
}

interface Human {
    void believe();

    void eat(String food);
}

//被代理类
class Superman implements Human {

    @Override
    public void believe() {
        System.out.println("I believe I can fly!");
    }

    @Override
    public void eat(String food) {
        System.out.println("超人爱吃：" + food);
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。


 */
class ProxyFactory {
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj) {//obj:被代理类的对象
        //解决问题二：代理类调用被代理类的同名方法。
        MyInvocationHandler m = new MyInvocationHandler();
        m.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), m);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//被代理的对象

    public void bind(Object obj) {//被代理对象赋值
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);

        humanUtil.method2();
        return returnValue;
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("====================通用方法一====================");
    }

    public void method2() {
        System.out.println("====================通用方法二====================");
    }
}