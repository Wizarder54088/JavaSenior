package com.atnjupt.java;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * <p>
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 * <p>
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author Wizarder
 * @create 2021-03-08 20:43
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            //1.
            raf = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            raf1 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");

            //2.
            byte[] b = new byte[1024];
            int len;
            while ((len = raf.read(b)) != -1) {
                raf1.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //3.
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"), "rw");

//            String str = "abcdefghijklmn";
//            raf.write(str.getBytes());
            raf.seek(5);//将指针调到角标为5的位置
            raf.write("uvw".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
   使用RandomAccessFile实现数据的插入效果
    */
    @Test
    public void test3() {
        RandomAccessFile raf = null;
        try {
            //指定读取文件的路径
            raf = new RandomAccessFile(new File("hello.txt"), "rw");

            //读取操作
            byte[] b = new byte[1024];
            int len;
            //提供sb装指针之后的数据
            StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
            raf.seek(5);
            //把指针之后的数据写入sb之中
            while ((len = raf.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            //回调指针
            raf.seek(5);
            raf.write("uvw".getBytes());
            //将StringBuilder中的数据写入到文件中
            raf.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //思考：将StringBuilder替换为ByteArrayOutputStream
    }

    @Test
    public void test() throws IOException {
        RandomAccessFile f = new RandomAccessFile(new File("abc.txt"), "rw");
        f.seek(5);
        byte[] b = new byte[10];
        int length;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((length = f.read(b)) != -1) {
            baos.write(b, 0, length);
        }

        f.seek(5);
        f.write("xxxxx".getBytes(StandardCharsets.UTF_8));
        f.write(baos.toByteArray());
        baos.close();
        f.close();
    }

}
