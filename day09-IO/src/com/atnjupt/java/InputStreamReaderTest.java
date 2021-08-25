package com.atnjupt.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * <p>
 * 2.作用：提供字节流与字符流之间的转换
 * <p>
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 * <p>
 * <p>
 * 4.字符集
 * ASCII：美国标准信息交换码。
 * 用一个字节的7位可以表示。
 * ISO8859-1：拉丁码表。欧洲码表
 * 用一个字节的8位表示。
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 * Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8：变长的编码方式，可用1-4个字节来表
 * <p>
 * <p>
 * 示一个字符。d
 *
 * @author Wizarder
 * @create 2021-03-07 12:38
 */
public class InputStreamReaderTest {
    /*

    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1() {
        InputStreamReader is = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
            is = new InputStreamReader(fis, "UTF-8");

            char[] cif = new char[10];
            int length;
            while ((length = is.read(cif)) != -1) {
                String s = new String(cif, 0, length);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*

    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() {
        InputStreamReader inputFile = null;
        OutputStreamWriter outputFile = null;
        try {
            //1.造文件、造流
            File file = new File("dbcp.txt");
            File file1 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            inputFile = new InputStreamReader(fis);
            outputFile = new OutputStreamWriter(fos, "gbk");

            //2.读写过程
            char[] cbuffer = new char[10];
            int length;
            while ((length = inputFile.read(cbuffer)) != -1) {
                outputFile.write(cbuffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (inputFile != null)
                    inputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputFile != null)
                    outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
