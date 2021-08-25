package easy;

/**
 * 题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 *
 * @author Wizarder
 * @create 2021-03-10 20:05
 */
public class FindWaterFlower {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int bai = i / 100;
            int shi = (i % 100) / 10;
            int ge = i % 10;
            if (i == (bai * bai * bai + shi * shi * shi + ge * ge * ge)) {
                System.out.println("数字：" + i + "是水仙花数");
            }
        }
    }
}
