package com.atnjupt.exer2;

import java.io.File;
import java.io.IOException;

/**
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1：并计算指定目录占用空间的大小
 * 拓展2：删除指定文件目录及其下的所有文件
 *
 * @author Wizarder
 * @create 2021-03-06 12:26
 */
public class ListFilesTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\io");

        printFile(file);
//        listSubFiles(file);
//        listAllSubFiles(file);

//        System.out.println(getFilesSize(file));
//        deletFile(file);
    }

    public static void printFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {//如果是文件夹就继续调用该方法。递归调用。
                if (f.length() == 0) {
                    System.out.println(f.getAbsolutePath());
                }
                printFile(f);
            } else {//是文件就输出
                System.out.println(f.getAbsoluteFile());
            }
        }
    }

    // 方式二：循环实现
    // 列出file目录的下级内容，仅列出一级的话
    // 使用File类的String[] list()比较简单
    public static void listSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            String[] list = file.list();
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    // 建议使用File类的File[] listFiles()
    public static void listAllSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                listAllSubFiles(f);
            }
        }
    }

    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public static long getFilesSize(File file) {
        long size = 0;
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] files = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : files) {
                size += getFilesSize(f);
            }
        }
        return size;
    }

    // 拓展2：删除指定的目录
    public static void deletFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : files) {// f代表file的每一个下级
                deletFile(f);
            }
        }
        // 删除自己
        file.delete();
    }

}
