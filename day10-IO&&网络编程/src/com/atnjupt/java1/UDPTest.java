package com.atnjupt.java1;


import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 * 获取数据getData()、获取数据的长度getLength();
 *
 * @author Wizarder
 * @create 2021-03-09 12:33
 */
public class UDPTest {
    @Test
    public void udpClient() throws IOException {
        DatagramSocket dgs = new DatagramSocket();

        String str = "我是发送的导弹！";
        byte[] b = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket dgp = new DatagramPacket(b, 0, b.length, localHost, 8989);
        dgs.send(dgp);

        dgs.close();
    }

    //接收端
    @Test
    public void udpServer() throws IOException {
        DatagramSocket server = new DatagramSocket(8989);

        byte[] b = new byte[100];
        DatagramPacket dgp = new DatagramPacket(b, 0, b.length);
        server.receive(dgp);

        System.out.println(new String(dgp.getData(), 0, dgp.getLength()));

        server.close();
    }
}
