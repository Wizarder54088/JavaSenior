package com.atnjupt.java;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Wizarder
 * @create 2021-03-08 21:28
 */
public class FileUtilsTest {
    @Test
    public void test1() {
        File f1 = new File("爱情与友情.jpg");
        File f2 = new File("爱情与友情2.jpg");

        try {
            FileUtils.copyFile(f1, f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
