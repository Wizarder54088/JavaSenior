package easy;


import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 *
 * @author Wizarder
 * @create 2021-02-22 22:57
 */
public class IntToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数：");
        while (sc.hasNext()) {
            int input = sc.nextInt();
            String binaryString = Integer.toBinaryString(input);
            int count = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
