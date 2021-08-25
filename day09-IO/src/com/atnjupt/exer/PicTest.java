package com.atnjupt.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wizarder
 * @create 2021-03-07 15:07
 */
public class PicTest {
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("爱情与友情.jpg");
            fos = new FileOutputStream("爱情与友情3secret.jpg");

            byte[] buffer = new byte[10];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                    fos.write(buffer[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("爱情与友情3secret.jpg");
            fos = new FileOutputStream("爱情与友情desecret.jpg");

            byte[] buffer = new byte[10];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                    fos.write(buffer[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
