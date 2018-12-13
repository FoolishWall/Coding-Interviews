package offer57;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2018/12/13  19:56
 * @description 和为S的数字
 * 题目一:
 * 例如：输入数组{1,2,4,7,11,15}和数字15，数组递增排序。由于4+11=15，因此输出4和11。
 * 题目二:
 * 和为s的连续正数序列(至少含有两个数)
 * 例如：输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列。
 */
public class FindSumS {
    //测试
    public static void main(String[] args) {
        int [] num = new int[]{1,2,4,7,11,15};
        int sum = 99;
        System.out.println(findContinuousSequence_mysolution(sum));
    }
    /**
     * 思路：设置指向数组头部和尾部的指针，若头部和尾部的数字和大于指定的和，
     * 则尾部指针向前移动，否则头部指针向后移动。
     * 这次的思路与剑指offer上的思路一致。
     * @param num 数组
     * @param sum 和
     */
    private static void findSumS_mysolution(int[] num, int sum) {
        //特殊输入
        if (num == null || num.length < 1) {
            return;
        }
        int head = 0;
        int tail = num.length - 1;
        while (head < tail) {
            int tempSum = num[head] + num[tail];
            if (tempSum == sum) {
                System.out.println(num[head] + " " + num[tail]);
                break;
            } else if (tempSum > sum) {
                tail--;
            } else {
                head++;
            }
        }
        System.out.println("不存在和为S的两个数!");
    }

    /**
     * 思路：从1开始往后加，直到和大于S，接着从1开始减，直到和小于S，然后接着往后加。
     * 若S为偶数，则一直加到S/2-2，否则加到S/2+1;
     * @param sum 和S
     */
    private static ArrayList<ArrayList<Integer>> findContinuousSequence_mysolution(int sum){
        //利用ArrayList保存结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //特殊输入
        if (sum < 3) {
            return result;
        }
        int tempSum = 0;
        int border;
        //判断奇数偶数的高效方法(number&1)==1为奇数，否则为偶数(位运算)
        if ((sum & 1) == 1) {
            //为奇数时，加到S/2+1
            border = sum / 2 + 1;
        } else {
            border = sum / 2 - 2;
        }

        int sequenceHead = 1;//记录序列的头部
        for (int i = 1; i <= border; i++) {
            tempSum += i;

            //和大于S，从序列的头部开始减,直到和小于或是等于S
            while (tempSum > sum) {
                tempSum -= sequenceHead;
                sequenceHead++;
            }

            if (tempSum == sum) {
                ArrayList<Integer> tempResult = new ArrayList<>();
                for (int j = sequenceHead; j <= i; j++) {
                    tempResult.add(j);
                }
                result.add(tempResult);
            }
        }

        return result;
    }
}
