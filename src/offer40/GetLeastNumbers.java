package offer40;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wall
 * @date 2019/1/20  15:54
 * @description 最小的k个数
 * 题目:输入n个整数，找出其中最小的k个数。
 */
public class GetLeastNumbers {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{4,5,1,6,2,7,3,8,9,10,15,12,4,4,4,4};
        int k = 4;
        getLeastNumbers_solution(data,4);
        System.out.println(getNumberK_solution(data,8));
    }

    /**
     * 最简单的思路
     * @param data
     * @param k
     */
    private static void getLeastNumbers_mysolution(int [] data,int k){
        //边界测试
        if (data == null || k ==0){
            return;
        }

        //排序数组
        Arrays.sort(data);

        for (int i = 0 ;i < k ; i++){
            System.out.println(data[i]);
        }
    }

    /**
     * 基于快速排序的思想，利用partition函数取数组中第k大的数字
     * @param data
     * @param k
     */
    private static void getLeastNumbers_solution(int [] data,int k){
        //边界测试
        if (data == null || data.length < 1 || k <= 0 || k > data.length){
            return;
        }
        int start = 0;
        int end = data.length-1;
        int index = partition(data,start,end);
        while (index != k-1){
            if (index > k-1){
                index = partition(data,start,index-1);
            }else {
                index = partition(data,index+1,end);
            }
        }
        for (int i = 0 ; i < k;i++){
            System.out.println(data[i]);
        }
    }

    /**
     * 返回比随机选取的数组值小的个数，时间复杂度为O(n)
     * @param data
     * @param start
     * @param end
     * @return
     */
    private static int partition(int [] data,int start,int end){
        if (data == null || start > end || start < 0 ){
            return -1;
        }
        //java取指定范围的随机数
        int index = new Random().nextInt(end-start+1)+start;
        System.out.println("数组下标："+index);
        swap(data,index,end);
        System.out.println("数组值："+data[index]);
        int small = start -1;
        //从左侧开始移动
        for (int i = start;i < end; i++){
            if (data[i] < data[end]){
                small++;
                if (small!=i){
                  swap(data,small,i);
                }
            }
        }
        small++;
        swap(data,small,end);
        return small;
    }

    /**
     * 交换函数
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int [] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 求数组中第k大的数字
     * @param data
     * @param k
     * @return
     */
    private static int getNumberK_solution(int [] data, int k){
        if (data == null || data.length < 1 || k <= 0 || k > data.length){
            return -1;
        }

        int start = 0;
        int end = data.length -1;
        int index = partition(data,start,end);

        while (index != k-1){
            if (index>k-1){
                index = partition(data,start,index-1);
            }else {
                index = partition(data,index+1,end);
            }
        }
        return data[k-1];
    }
}
