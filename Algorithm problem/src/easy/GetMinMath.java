package easy;

import java.util.Scanner;

/**
 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 *
 * @author Wizarder
 * @create 2021-03-10 20:19
 */
public class GetMinMath {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print( "请键入一个正整数:");
//        int    n    = s.nextInt();
//        int k=2;
//        System.out.print(n + "=" );
//        while(k <= n) {
//            if(k == n) {
//            System.out.println(n);
//            break;}
//            else if( n % k == 0) {
//                System.out.print(k + "*");
//                n = n / k;
//            }
//            else
//                k++;
//        }
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入正整数:");
        int number = scan.nextInt();
        int k = 2;
        System.out.print(number + " = ");
        while (k <= number) {
            if (k == number) {
                System.out.println(number);
                break;
            } else if (number % k == 0) {
                System.out.print(k + "*");
                number = number / k;
            } else
                k++;
        }

    }
}
