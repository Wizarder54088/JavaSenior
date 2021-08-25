package com.atnjupt.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * <p>
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 * @author Wizarder
 * @create 2021-03-07 11:35
 */
public class FileInputOutputStreamTest {
    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void test() {
        FileInputStream fis = null;
        try {
            //造流
            fis = new FileInputStream(new File("hello.txt"));
            //读取操作
            byte[] buffer = new byte[5];
            int length;//记录每次读取的个数
            while ((length = fis.read(buffer)) != -1) {
                String s = new String(buffer, 0, length);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        实现对图片的复制操作
 */
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //造源文件和目的文件
            File scrFile = new File("爱情与友情.jpg");
            File desFile = new File("爱情与友情1.jpg");

            //造流
            fis = new FileInputStream(scrFile);
            fos = new FileOutputStream(desFile);

            //复制操作
            byte[] buffer = new byte[10];
            int length;//每次读取的个数
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyPathFile(String scr, String des) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //造源文件和目的文件
            File scrFile = new File(scr);
            File desFile = new File(des);

            //造流
            fis = new FileInputStream(scrFile);
            fos = new FileOutputStream(desFile);

            //复制操作
            byte[] buffer = new byte[1024];
            int length;//每次读取的个数
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        String scrPath = "C:\\Users\\WIzarder\\Desktop\\卡莎伪五杀.mp4";
        String desPath = "C:\\Users\\WIzarder\\Desktop\\卡莎伪五杀1.mp4";

        copyPathFile(scrPath, desPath);

        long end = System.currentTimeMillis();
        System.out.println(end - start);//3570
    }
}
