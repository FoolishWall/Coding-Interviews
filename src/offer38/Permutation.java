package offer38;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wall
 * @date 2019/1/17  10:27
 * @description 字符串的排列
 */
public class Permutation {
    //测试
    public static void main(String[] args) {
//        String str = "ABC";
//        char [] strArr = str.toCharArray();
//        ArrayList<String> result = new ArrayList<>();
//        permutation_solution(result,strArr,0,2);
//        System.out.println(result);

        check(0);
        System.out.println(count);
    }


    private static void permutation_solution(ArrayList<String> result, char[] strArr, int start, int end) {
        if (strArr == null || start == end) {
            result.add(Arrays.toString(strArr));
            return;
        }


        for (int i = start; i <= end; i++) {
            if (i==start || strArr[start] != strArr[i]) {
                swap(strArr, start, i);
                permutation_solution(result, strArr, start + 1, end);
                swap(strArr, start, i);
            }
        }
    }

    private static void swap(char [] strArr,int i,int j){
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
    }


    /**
     * 在8*8的国际象棋上摆放8个皇后，使其不能互相攻击，
     * 即任意两个皇后不得处于同一行、同一列或者同一条对角线上
     */

    /**
     * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
     */
    private static int max = 4;
    /**
     * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
     */
    private static int[] array = new int[max];

    private static int count = 0;
    /**
     * n代表当前是第几个皇后
     * @param n
     * 皇后n在array[n]列
     */
    private static void check(int n) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            count++;
            print();
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //
            //Math.abs(n - i) == Math.abs(array[n] - array[i])判断皇后是不是在同一条对角线上。
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private static void print()  {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println();
    }
}
