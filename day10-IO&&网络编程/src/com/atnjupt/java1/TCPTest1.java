package com.atnjupt.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @author Wizarder
 * @create 2021-03-08 22:13
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;

        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            socket = new Socket(byName, 8686);
            //2.获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();
            //3.写出数据的操作
            outputStream.write("你好，我是路虎！".getBytes());
            //4.资源的关闭
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //服务端
    @Test
    public void service() {
        ServerSocket service = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            service = new ServerSocket(8686);
            //2.调用accept()表示接收来自于客户端的socket
            accept = service.accept();
            //3.获取输入流
            inputStream = accept.getInputStream();
            //不建议这样写，可能会有乱码,因为你每次读取的字节长度为2，UTF-8三个字节一个汉字，就出现乱码了。
//        byte[] buffer = new byte[2];
//        int len;
//        while((len = inputStream.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
//            //4.读取输入流中的数据 ByteArrayOutputStream有个缓存，默认32个字节
            bos = new ByteArrayOutputStream();
            byte[] buff = new byte[2];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到了来自：" + accept.getInetAddress().getHostName() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
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
                if (service != null)
                    service.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
