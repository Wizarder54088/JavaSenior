package com.atnjupt.java;

/**
 * 静态代理举例
 * <p>
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 *
 * @author Wizarder
 * @create 2021-03-12 17:12
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxClothFactory prox = new ProxClothFactory(nike);
        prox.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxClothFactory implements ClothFactory {
    private ClothFactory factory;//被代理类

    public ProxClothFactory(ClothFactory factory) {//初始化被代理类
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理厂准备!");

        factory.produceCloth();//执行被代理类的方法

        System.out.println("代理厂结束！");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike厂生成衣服!");
    }
}
