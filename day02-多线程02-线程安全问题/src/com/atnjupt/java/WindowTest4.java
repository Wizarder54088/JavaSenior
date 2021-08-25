package com.atnjupt.java;

import javax.xml.stream.events.StartDocument;

/**
 * @author Wizarder
 * @create 2021-02-18 17:57
 */
class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
            if (ticket <= 0) {
                break;
            }
        }
    }

    public static synchronized void show() {//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票为：" + ticket);

            ticket--;


        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");


        w1.start();
        w2.start();
        w3.start();
    }
}
