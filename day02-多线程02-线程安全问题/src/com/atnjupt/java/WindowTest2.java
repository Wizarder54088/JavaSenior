package com.atnjupt.java;

/**
 * **
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * <p>
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * <p>
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 * @author Wizarder
 * @create 2021-02-18 17:11
 */
class Window2 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            //正确的
            synchronized (Window2.class) {//this.getClass() Class clazz = Window2.class,Window2.class只会加载一次类也是对象
                //错误的方式：this代表着t1,t2,t3三个对象
//              synchronized (this){
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票为：" + ticket);

                    ticket--;

                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
