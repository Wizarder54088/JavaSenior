package exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 * 3）将排序后的数组变成字符串。
 *
 * @author Wizarder
 * @create 2021-02-23 14:34
 */
public class SortString {
    public static void sortString(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);
        System.out.println(s);

    }

    public static void main(String[] args) {
        String s1 = "abcwerthelloyuiodef";
        sortString(s1);
    }

    @Test
    public void test() {


    }
}
