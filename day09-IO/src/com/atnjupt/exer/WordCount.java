package com.atnjupt.exer;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 * <p>
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 * <p>
 * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * map.put('a',18);
 * map.put('你',2);
 * <p>
 * 3.把map中的数据写入文件
 *
 * @author Wizarder
 * @create 2021-03-07 15:20
 */
public class WordCount {
    public static void main(String[] args) {
        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        try {
            File file = new File("dbcp.txt");
            bfr = new BufferedReader(new FileReader(new File(file.getParent(), "day09-IO\\dbcp.txt")));
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            char[] cbuff = new char[20];
            int length;
            while ((length = bfr.read(cbuff)) != -1) {
                for (int i = 0; i < length; i++) {
                    // 判断char是否在map中第一次出现
                    if (map.get(cbuff[i]) == null) {
                        map.put(cbuff[i], 1);
                    } else {
                        map.put(cbuff[i], map.get(cbuff[i]) + 1);
                    }
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            bfw = new BufferedWriter(new FileWriter(new File("wordaccount.txt")));

            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bfw.write("空格=" + entry.getValue());
                        break;
                    case '\t'://\t表示tab 键字符
                        bfw.write("tab键=" + entry.getValue());
                        break;
                    case '\r'://
                        bfw.write("回车=" + entry.getValue());
                        break;
                    case '\n'://
                        bfw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bfw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bfw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfw != null)
                    bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bfr != null)
                    bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

