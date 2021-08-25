package exer;

/**
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @author Wizarder
 * @create 2021-02-22 14:02
 */
public class GetMaxSubstring {
    public static String getMaxSubString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxString = (str1.length() >= str2.length()) ? str1 : str2;
            String minString = (str1.length() < str2.length()) ? str1 : str2;
            int length = minString.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    if (maxString.contains(minString.substring(x, y))) {
                        return minString.substring(x, y);
                    }
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "abcwerthelloyuiodef";
        String s2 = "cvhellobnm";
        System.out.println(getMaxSubString(s2, s1));
    }
}
