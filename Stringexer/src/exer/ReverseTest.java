package exer;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行 反转 。比如“abcdefg” 反
 * 转为”abfedcg
 *
 * @author Wizarder
 * @create 2021-02-22 13:33
 */
public class ReverseTest {
    //方式一
    public static String reverseString(String str, int start, int end) {
        char[] c = str.toCharArray();
        return reversChar(c, start, end);

    }

    private static String reversChar(char[] ch, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

        }
        return new String(ch);
    }

    //方式二使用String拼接
    public static String reverseString1(String str, int start, int end) {
        if (str != null) {
            String s1 = str.substring(0, start);
            for (int i = end; i >= start; i--) {
                s1 += str.charAt(i);
            }
            s1 += str.substring(end + 1);


            return s1;
        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public static String reverseString2(String str, int start, int end) {
        if (str != null) {
            StringBuilder s1 = new StringBuilder(str.length());
            s1.append(str.substring(0, start));
            for (int i = end; i >= start; i--) {
                s1.append(str.charAt(i));
            }
            s1.append(str.substring(end + 1));
            return new String(s1);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(ReverseTest.reverseString2(s, 1, 4));
    }

}
