package exer;

import org.junit.Test;

import java.awt.*;

/**
 * @author Wizarder
 * @create 2021-02-22 13:19
 */
public class TrimTest {
    public static void main(String[] args) {
        String s1 = "  l  ";
        String s2 = TrimTest.myTrim(s1);
        System.out.println("---" + s1 + "---");
        System.out.println("---" + s2 + "---");
    }

    public static String myTrim(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end && str.charAt(start) == ' ') {
            start++;
        }
        while (start < end && str.charAt(end) == ' ') {
            end--;
        }
        if (start == end) {
            if (str.charAt(start) == ' ') {
                return " ";
            }
        }
        return str.substring(start, end + 1);

//        int s = 0;
//        int e = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) != ' ') {
//
//                break;
//            }
//            s++;
//        }
//        for (int i = str.length() - 1; i >= 0; i--) {
//            if (str.charAt(i) != ' ') {
//                break;
//            }
//            e++;
//        }
//
//        return str.substring(s,str.length()-e );


    }

    @Test
    public void test1() {
        boolean flag;
        for (int i = 2; i <= 100; i++) {
            flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

}


