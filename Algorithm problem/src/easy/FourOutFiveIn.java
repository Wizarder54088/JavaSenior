package easy;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * @author Wizarder
 * @create 2021-02-22 23:04
 */
public class FourOutFiveIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入正浮点数：");
        double input = sc.nextDouble();
        System.out.println((int) (input + 0.5));
    }
}
