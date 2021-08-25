package exer;

/**
 * 一个应用程序，接受用户输入的一行字符串，统计字符个数，然后反序输出
 *
 * @author Wizarder
 * @create 2021-02-22 12:41
 */
public class InputString {
    public static void main(String[] args) {
        String str = args[0];
        int j = str.length();
        for (int i = j - 1; i >= 0; i--) {
            System.out.println(str.charAt(i) + "");
        }
    }
}
