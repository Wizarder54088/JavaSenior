package com.atnjupt.java;

import java.util.Objects;

/**
 * @author Wizarder
 * @create 2021-02-23 20:54
 */
public class Goods implements Comparable {
    private int price;
    private String name;


    public Goods() {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Goods(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Goods{" + "price=" + price + ", name='" + name + '\'' + '}';
    }


    //指明商品比较大小的方式:按照价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods o1 = (Goods) o;
            //方式一
            if (this.price > o1.price) {
                return 1;
            } else if (this.price < o1.price) {
                return -1;
            } else {
//                return 0;
                return this.name.compareTo(o1.name);
            }
//            return Double.compare(this.price,o1.price);
        }

        throw new RuntimeException("比较对象类型不符合！");
    }
}
