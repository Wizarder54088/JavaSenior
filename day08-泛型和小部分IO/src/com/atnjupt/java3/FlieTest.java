package com.atnjupt.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用
 * <p>
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 *
 * @author Wizarder
 * @create 2021-03-04 18:31
 */
public class FlieTest {
    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     */
    @Test
    public void test1() {
        //构造器1
        File file = new File("hello.txt");
        File file1 = new File("G:\\workspace_idea\\JavaSenior\\day08-泛型和小部分IO\\hi.txt");

        System.out.println(file);
        System.out.println(file1);

        //构造器2：
        File file2 = new File("G:\\workspace_idea\\", "JavaSenior");
        System.out.println(file2);

        //构造器3：
        File file3 = new File(file2, "day08-泛型和小部分IO");
        System.out.println(file3);
    }

    /*
public String getAbsolutePath()：获取绝对路径
public String getPath() ：获取路径
public String getName() ：获取名称
public String getParent()：获取上层文件目录路径。若无，返回null
public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
public long lastModified() ：获取最后一次的修改时间，毫秒值

如下的两个方法适用于文件目录：
public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组


  */
    @Test
    public void test2() {
        File file = new File("hello.txt");

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println();

        File file1 = new File("D:\\io\\hi.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

    }

    @Test
    public void test3() {
        File file = new File("G:\\workspace_idea\\JavaSenior");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);

        }
    }

    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
     比如：file1.renameTo(file2)为例：
        要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */
    @Test
    public void test4() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("G:\\workspace_idea\\JavaSenior\\day08-泛型和小部分IO\\hi.txt");
        file1.createNewFile();
        System.out.println(file1.renameTo(file2));
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功！");
        }
//        file1.delete();
//        file2.delete();
//        System.out.println(file1.renameTo(file2));
    }

    /*
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile() ：判断是否是文件
    public boolean exists() ：判断是否存在
    public boolean canRead() ：判断是否可读
    public boolean canWrite() ：判断是否可写
    public boolean isHidden() ：判断是否隐藏

         */
    @Test
    public void test5() throws IOException {
        File file = new File("hello.txt");
        file.createNewFile();
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        System.out.println();

        File file1 = new File("D:\\io");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /*
    创建硬盘中对应的文件或文件目录
public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。

     */
    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        } else {
            file.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7() {
        //文件目录的创建
        File file = new File("D:\\io\\io3");
        if (!file.exists()) {
            file.mkdir();
            System.out.println("创建成功！");
        } else {
            file.delete();
            System.out.println("删除成功！");
        }

        File file1 = new File("D:\\io\\io2\\io1");
        System.out.println(file1.mkdir());
        if (!file.exists()) {
            file1.mkdirs();
            System.out.println("创建成功！");
        } else {
            file1.delete();
            System.out.println("删除成功！");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1\\io4");
        file3 = new File("D:\\io\\io2\\io1");
        System.out.println(file3.delete());
    }


}
