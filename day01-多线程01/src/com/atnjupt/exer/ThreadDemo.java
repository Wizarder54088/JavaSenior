package com.atnjupt.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 * @author Wizarder
 * @create 2021-02-15 19:53
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 2 != 0) {

                System.out.println(getName() + ":" + i);
            }

        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {

                System.out.println(getName() + ":" + i);
            }

        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1 =new MyThread1();
//        m1.setName("线程1");
//        m1.start();
//        MyThread2 m2  = new MyThread2();
//        m2.setName("线程2");
//        m2.start();
        //创建Thread的匿名子类方式
        new Thread() {

            @Override
            public void run() {
                Thread.currentThread().setName("线程1");
                for (int i = 0; i < 100; i++) {

                    if (i % 2 != 0) {

                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程2");
                for (int i = 0; i < 100; i++) {

                    if (i % 2 == 0) {

                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }

        }.start();
    }
}
