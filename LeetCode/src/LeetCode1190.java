import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 反转每对括号间的子串
 * 方法一：暴力破解
 * 方法二：采用双栈方法
 *
 * @author Wizarder
 * @create 2021-04-16 17:03
 */
public class LeetCode1190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String s = reverseParentheses(next);
        System.out.println(s);
    }

    public static String reverseParentheses(String s) {
//        //用来存储最终结果
//        Stack<Character> stack = new Stack<>();
//        //零时存储括号内翻转的元素
//        Stack<Character> buffer = new Stack<>();
//        for (char c:s.toCharArray()){
//            if (c != ')'){
//                //把 ) 左边的字符存储到stack中
//                stack.push(c);
//            }else{
//                while (stack.peek() != '('){
//                    //把 ( 右侧的所有元素存到buffer栈里，实现翻转。
//                    buffer.push(stack.pop());
//                }
//                //出循环的时候正好匹配到 (所以得删除。
//                stack.pop();
//                //把buffer里的所有元素存入stack里
//                stack.addAll(buffer);
//                //buffer清空存储下次数据
//                buffer.clear();
//            }
//        }
//        return stack.toString();
        //方法二：
        Stack<Character> stack = new Stack<>();//存储最终结果
        ArrayList<Character> buff = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (stack.peek() != '(') {
                    buff.add(stack.pop());
                }
                stack.pop();
                stack.addAll(buff);
                buff.clear();
            }
        }
        return stack.toString();


    }

    public static void reverseChar(char[] c, int start, int end) {
        while (end > start) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    //方法二暴力破解法
    /*public static  String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer(s.length());
        char[] c = s.toCharArray();
        for(int i = 0;i<c.length;i++){
            if(c[i] == '('){
                stack.push(i);
            }else if(c[i] == ')'){
                reverseChar(c,stack.pop()+1,i-1);
            }
        }
        for(char ch:c){
            if(ch!='('&&ch!=')'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    private static void reverseChar(char[] c,int start,int end){
        while(end > start){
            char temp = c[start];
            c[start] = c[end];
            c[end]= temp;
            start++;
            end--;
        }
    }*/
}
