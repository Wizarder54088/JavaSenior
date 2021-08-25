package exer;

/**
 * @author Wizarder
 * @create 2021-03-30 21:21
 */
public class StringReverse {
    public static void main(String[] args) {
        String s = "12abcd56";
        System.out.println(reverseString(s, 2, 5));
    }

    public static String reverseString(String s, int start, int end) {
        String s1 = s.substring(0, start);
        String s2 = s.substring(start, end + 1);
        String s3 = s.substring(end + 1);

        StringBuilder sb = new StringBuilder(s2);
        StringBuilder reverseSb = sb.reverse();
        String reverseS3 = new String(reverseSb);

        String reverse = s1 + reverseS3 + s3;
        return reverse;
    }
}
