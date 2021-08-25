package com.atnjupt.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 * @author Wizarder
 * @create 2021-03-06 17:16
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsoluteFile());//相较于当前工程
        File file1 = new File("da09\\hello.txt");
        System.out.println(file1.getAbsoluteFile());
    }
    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */

    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");


            //2.提供具体的流
            fileReader = new FileReader(file);


            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fileReader = new FileReader(file);

            //3.数据的读入
            char[] cbuff = new char[3];
            int length;
            while ((length = fileReader.read(cbuff)) != -1) {
                //方式一：
                //错误的写法
//                for(int i = 0;i < cbuff.length;i++){
//                    System.out.print(cbuff[i]);
//                }
                //正确的写法
//                 for (int i = 0; i <length ; i++) {
//                    System.out.print(cbuff[i]);
//                }
                //方式二：
                //错误的写法,对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);
                //正确的写法
                String str = new String(cbuff, 0, length);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
    @Test
    public void test3() {
        FileWriter fileWriter = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file, false);

            //3.写出的操作
//            fileWriter.write("how are you?\n");
//            fileWriter.write("i am fine");
            fileWriter.write("how do you do?\n");
            fileWriter.write("i am not good");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test4() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File file = new File("hello.txt");
            File file1 = new File("hello2.txt");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);

            //3.数据的读入和写出操作
            char[] cbuff = new char[5];
            int length;
            while ((length = fileReader.read(cbuff)) != -1) {
//                String s = new String(cbuff,0,length);
//                System.out.print(s);
                fileWriter.write(cbuff, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.关闭流资源
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
