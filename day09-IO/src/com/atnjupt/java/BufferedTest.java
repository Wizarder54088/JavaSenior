package com.atnjupt.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * <p>
 * 3. 处理流，就是“套接”在已有的流的基础上。
 *
 * @author Wizarder
 * @create 2021-03-07 12:03
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void test() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造流
            bis = new BufferedInputStream(new FileInputStream(new File("爱情与友情.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("爱情与友情2.jpg")));

            //复制操作
            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int length;//记录读取的个数；
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
                //bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                //4.资源关闭
                //要求：先关闭外层的流，再关闭内层的流
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
    }

    //实现文件复制的方法
    public static void bufferedCopyFile(String src, String des) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造流和文件
            bis = new BufferedInputStream(new FileInputStream(new File(src)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(des)));

            //复制操作
            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int length;//记录读取的个数；
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
                //bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                //4.资源关闭
                //要求：先关闭外层的流，再关闭内层的流
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();

        String scr = "C:\\Users\\WIzarder\\Desktop\\卡莎伪五杀.mp4";
        String des = "C:\\Users\\WIzarder\\Desktop\\卡莎伪五杀2.mp4";
        bufferedCopyFile(scr, des);

        long end = System.currentTimeMillis();
        System.out.println(end - start);//970
    }

    /*
   使用BufferedReader和BufferedWriter实现文本文件的复制

    */
    @Test
    public void test3() {
        BufferedReader brs = null;
        BufferedWriter bws = null;
        try {
            //造流和文件
            brs = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bws = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //复制操作
            //方式一
//             char[] cbuff = new char[10];
//             int length;
//             while ((length = brs.read(cbuff))!=-1){
//                 bws.write(cbuff,0,length);
//                 //bws.flush();
//             }
            //方式二
            String str;
            while ((str = brs.readLine()) != null) {
                //方法一
//                 bws.write(str+"\n");//data中不包含换行符
                //方法二：
                bws.write(str);//data中不包含换行符
                bws.newLine();//提供换行的操作

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (bws != null)
                    bws.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (brs != null)
                    brs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

