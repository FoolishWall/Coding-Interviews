package exam2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/3/11  11:07
 * @description 腾讯提前批算法第四题：滑动窗口
 * 题目描述：m种不同颜色的气球，编号1到m，n发子弹，求打爆所有颜色的气球最少用了连续几抢。
 *
 * 输入示例：
 * 输入n，m
 * 12 5
 * 2 5 3 1 3 2 4 1 0 5 4 3
 * 输出示例：
 * 6
 */
public class MinCoverColor {
    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //射击的总次数
        int times = scanner.nextInt();
        //总的颜色种类
        int colors = scanner.nextInt();
        int[] data = new int[times];

        for (int i = 0; i < times; i++) {
            data[i] = scanner.nextInt();
        }

        System.out.println(getMinLength(data,colors));
    }

    private static int getMinLength(int[] data, int colors) {
        //特殊测试
        if (data.length < 1 || colors < 1) {
            return -1;
        }
        //维护一个map，记录气球的颜色
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= colors; i++) {
            map.put(i, 1);
        }

        int left = 0, right = 0;
        //记录子串包含气球颜色的个数
        int count = 0;
        //最短子串长度
        int minLength = Integer.MAX_VALUE;
        //遍历数组data
        for (int tempData : data) {
            if (map.containsKey(tempData)) {
                count = (map.get(tempData) > 0) ? count + 1 : count;
                map.put(tempData, map.get(tempData) - 1);
            }

            while (count == map.size()) {
                if ((right - left) < minLength) {
                    minLength = right - left + 1;
                }

                if (map.containsKey(data[left])) {
                    count = (map.get(data[left]) < 0) ? count : count - 1;
                    map.put(data[left], map.get(data[left]) + 1);
                    left++;
                }
            }
            right++;
        }
        return minLength;
    }
}
