package exer;

import javax.management.MXBean;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
 *
 * @author Wizarder
 * @create 2021-02-22 14:01
 */
public class GetStringTime {
    public static int findStringTime(String s1, String s2) {
        String maxString = (s1.length() >= s2.length()) ? s1 : s2;
        String minString = (s1.length() < s2.length()) ? s1 : s2;

        int index = 0;
        int count = 0;
        while ((index = maxString.indexOf(minString)) != -1) {

            //方式一
            count++;
            maxString = maxString.substring(index + minString.length());


        }
        return count;
//        while ((index = maxString.indexOf(minString,index)) != -1){
//
//            //方式一改进
//            count ++;
//            index += minString.length();
//
//
//    }

//        return count;

    }

    public static void main(String[] args) {
        String s1 = "abkkcadkabkebfkaabkskab";
        String s2 = "ab";

        System.out.println(findStringTime(s1, s2));
    }
}
