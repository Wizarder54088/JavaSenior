package com.atnjupt.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 继承线程用lock方式实现线程安全
 *
 * @author Wizarder
 * @create 2021-02-18 21:31
 */
class Window1 extends Thread {
    private static int ticket = 100;
    private static ReentrantLock lock = new ReentrantLock();//继承Thread类需要用同一把锁

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "售票为:" + ticket);
                    ticket--;

                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
