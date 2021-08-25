/**
 * 跳跃游戏2
 * 方法一：反向查找出发位置
 * 方法二：正向查找可到达的最大位置
 *
 * @author Wizarder
 * @create 2021-04-17 14:58
 */
public class LeetCode45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 2, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    //方法一：
   /* public static int jump(int[] nums){
        //记录跳跃的次数
        int step = 0;
        //最远的起跳位置
        int position = nums.length -1;
        while (position > 0){
            //每次遍历找到到最远的起跳位置。
            for (int i = 0;i < position ;i++){
                if((i + nums[i]) >= position){
                    position = i;
                    step++;
                    break;
                }
            }
        }

        return step;
    }*/
    //方法二：
    public static int jump(int[] nums) {
        //最大的跳跃点
        int maxPositon = 0;
        //到最大位置起跳
        int end = 0;
        //起跳次数
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPositon = Math.max(maxPositon, i + nums[i]);
            if (i == end) {
                end = maxPositon;
                count++;
            }
        }

        return count;

    }
}
