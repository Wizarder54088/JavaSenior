package com.atnjupt.exer2;

import org.junit.Test;

import java.io.File;

/**
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 *
 * @author Wizarder
 * @create 2021-03-06 12:10
 */
public class FindJPGFileTest {
    @Test
    public void test1() {
        File file = new File("D:\\io\\io1\\io4");
        String[] list = file.list();
        for (String s : list) {
            if (s.endsWith(".jpg")) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("D:\\io\\io1\\io4");
        File[] fileNames = file.listFiles();
        for (File f : fileNames) {
            if (f.getName().endsWith("jpg")) {
                System.out.println(f.getName());
            }
        }
    }
}
