package offer39;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author wall
 * @date 2018/11/2  10:34
 * @description 数组中出现次数超过一半的数字
 * 题目描述：求数组中出现的次数超过数组长度的一半的数字。
 * 思路1：维护一个map，记录各个数字出现的次数。
 *
 */
public class MoreThanHalfNum {
    //测试
    public static void main(String[] args) {
//        int [] data = new int[]{9,4,1,2,3,6,5,7,8,4,5,6,8,9};
//        quickSort_core(data,0,data.length-1);
//        for (int aData:data){
//            System.out.println(aData);
//        }


        int [] data = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum_solution(data));
    }

    private static int moreThanHalfNum_mysolution(int[] data){
        if (data==null){
            return 0;
        }
        int num = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组，填充map
        for (int aData:data) {
            map.put(aData,map.getOrDefault(aData,0)+1);
        }
        //遍历map，找出超过数组长度一半的数字
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue()>(data.length/2)){
                num=entry.getKey();
            }
        }

        return num;
    }

    /**
     * 不修改输入数组，维护两个值：一个是数组中的一个数字；另一个是次数。
     * @param data
     * @return
     */
    private static int moreThanHalfNum_solution(int [] data){
        //特殊测试
        if (data ==null || data.length < 1){
            return -1;
        }

        int result = data[0];
        int count = 1;

        /**
         * 遍历一遍数组,当前数字与后一个数字比较是否相等,
         * 相等count加1，不相等count减1，
         * 若count为0，则统计后一个数字的次数
         */
        for (int i = 1;i < data.length;i++){
            if (data[i] == result){
                count++;
            }else
            {
                count--;
            }

            if (count == 0){
                result = data[i];
                count = 1;
            }
        }

        if (!checkMoreThanHalf(data,result)){
            return -1;
        }
        return result;
    }

    private static  boolean checkMoreThanHalf(int [] data,int result){
        //次数
        int times = 0;
        //遍历一遍数组，统计result出现的次数
        for (int temp:data) {
            if (temp == result){
                times++;
            }
        }

        return times > data.length / 2;
    }

    //复习快速排序
    //快速排序需要注意的地方
    //1.从基数的对面开始
    //2.当选用随机基准数时，需要将基准数放在开头或是结尾，以确定，从哪侧开始移动（依然是考虑第一个注意点）


    //快速排序为什么要从基数的另一侧开始，例如:6,1,2,7,9，以6为基数，从左侧开始，会将7放到最左侧,排序错乱
    private static void quickSort_core(int [] data,int head,int tail){
        int start = head;
        int end = tail;

        //随机选取基准数
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        int number = data[index];

        swap(data,index,end);

        while (start <end) {
            while (start<end&&data[start] <= number) {
                start++;
            }
            while (start<end&&data[end] >= number) {
                end--;
            }
            swap(data, start, end);
        }
        swap(data,tail,start);

        if (start>head)
            quickSort_core(data,head,start-1);
        if (end<tail)
            quickSort_core(data,end+1,tail);
    }
    //交换函数
    private static void swap(int [] data,int i,int j){
        int temp = data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
