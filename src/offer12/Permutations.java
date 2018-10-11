package offer12;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wall
 * @date 2018/10/10  20:30
 * @description 全排列
 */
public class Permutations {
    public static void main(String[] args) {
        String str = "ABC";
        char[] stringArr = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        permutations_solution(result, stringArr, 0, 2);
        System.out.println(result);
    }


    private static void permutations_solution(ArrayList<String> result, char[] stringArr, int start, int end) {
        if (start == end) {
            result.add(Arrays.toString(stringArr));
            return;
        }

        for (int i = start; i <= end; ++i) {
            if (i == start || stringArr[i] != stringArr[start]) {
                //在排列的时候进行判断如果后面的元素与start相同时就不进行排序。
                // 这样就可以避免对重复元素进行排序
                swap(stringArr, start, i);
                permutations_solution(result, stringArr, start + 1, end);
                swap(stringArr, start, i);
            }
        }

    }

    //交换函数
    private static void swap(char[] stringArr, int i, int j) {
        char temp = 0;
        temp = stringArr[j];
        stringArr[j] = stringArr[i];
        stringArr[i] = temp;
    }
}
