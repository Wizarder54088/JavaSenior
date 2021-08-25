package com.atnjupt.exer2;

import java.io.File;
import java.io.IOException;

/**
 * @author Wizarder
 * @create 2021-03-04 18:26
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\io\\io1\\io4");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File file1 = new File(file, "haha.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }
    }
}
