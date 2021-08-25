/**
 * 最长公共子串
 *
 * @author Wizarder
 * @create 2021-04-22 20:54
 */
public class NC127 {
    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(getMaxSubString(s1, s2));
    }

    public static String getMaxSubString(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int max = 0;//记录最大长度
        int index = 0;//记录最大索引
        int[][] dp = new int[m + 1][n + 1];//记录Str1 0-i-1和str2 0-j-1的最大公共子串长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];//最大长度
                        index = i;//对应字符索引后一位。
                    }
                } else {
                    dp[i][j] = 0;//也可以不写 默认为0
                }
            }
        }
        return max == 0 ? "" : str1.substring(index - max, index);
//        int m = str1.length(), n = str2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        int max = 0, index = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    dp[i + 1][j + 1] = dp[i][j] + 1;
//                    if (max < dp[i + 1][j + 1]) {
//                        max = dp[i + 1][j + 1];
//                        index = i + 1;
//                    }
//                }
//            }
//        }
//        return max == 0 ? "-1" : str1.substring(index-max,index);

    }
}
