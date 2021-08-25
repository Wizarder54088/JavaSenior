package com.atnjupt.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author Wizarder
 * @create 2021-03-09 11:48
 */
public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;
        try {
            //1
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
            //2
            outputStream = socket.getOutputStream();
            //3
            fis = new FileInputStream("beauty.jpg");
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            //1.
            serverSocket = new ServerSocket(8989);
            //2.
            accept = serverSocket.accept();
            //3.
            inputStream = accept.getInputStream();
            //4.
            fos = new FileOutputStream(new File("beauty1.jpg"));
            //5.
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("收到来自：" + accept.getInetAddress().getHostName() + "的文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (accept != null)
                    accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
