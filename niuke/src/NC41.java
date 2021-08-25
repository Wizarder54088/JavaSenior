import java.util.LinkedList;

/**
 * leetcode 48题目
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 *
 * @author Wizarder
 * @create 2021-04-20 15:40
 */
public class NC41 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 3};
        int i = maxLength(arr);
        System.out.println(i);
    }

    public static int maxLength(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();//存储不重复的序列。
        int length = 0;//记录最大长度
        for (int i = 0; i < arr.length; i++) {//遍历数组
            //list里面始终保存着不同的数据。动态的赋值给length然后比较。
            if (list.contains(arr[i])) {
                int index = list.indexOf(arr[i]);
                while (index-- >= 0) {
                    list.removeFirst();
                }
            }
            list.add(arr[i]);
            length = Math.max(length, list.size());//动态比较
        }
        return length;


    }
}
