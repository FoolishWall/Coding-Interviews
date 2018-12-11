package offer56;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wall
 * @date 2018/12/10  22:02
 * @description 数组中数字出现的次数
 * 题目1：数组中只出现一次的两个数字
 * 例如：输入数组{1,2,3,4,5,6,1,2,3,4}
 * 输出5,6
 * 要求时间复杂度是O(n),空间复杂度是O(1)
 *
 * 题目2：数组中唯一只出现一次的数字，其他数字都出现了三次。
 */
public class FindNumsAppearOnce {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{1,2,3,4,5,6,1,2,3,4};
        int [] num = new int[]{2,2,2,3,3,3,4,4,4,5};
        findNumAppearOnceInThreeArr(num);
    }

    private static void findNumsAppearOnce_mysolution(int [] data){
        //利用HashMap存储数组中数字的出现次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int aData:data){
            map.put(aData,map.getOrDefault(aData,0)+1);
        }
        //将数组中出现一次的数字打印出来
        //遍历map
        for (Map.Entry entry:map.entrySet()){
            if ((int)(entry.getValue()) == 1){
                System.out.println(entry.getKey());
            }
        }
    }

    //提示：数组中只有一个数字出现一次，找出这个数
    //思路：java中一个数和自己异或是0的原理
    private static void findOnlyOneNumAppearOnce(int [] data){
        int result = 0;
        for (int aData:data) {
            result = result^aData;
        }
        System.out.println(result);
    }

    //思路：将数组分为两组，每组分别含有一个只出现一次的数字
    private static void findNumsAppearOnce_solution(int [] data){
        int temp = 0;
        for (int aData:data) {
            temp ^= aData;
        }
        int indexBit = findIndexBit(temp);
        //第一组只出现一次的数字
        int result1 = 0;
        //第二组只出现一次的数字
        int result2 = 0;
        for (int aData:data) {
            //如果是第一组的数字
            if (isGroup1(aData,indexBit)){
                result1 ^= aData;
            }else result2 ^= aData;
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 获取异或结果二进制中首次出现1的下标
     * @param temp 依此与数组中的数字异或后的结果
     * @return
     */
    private static int findIndexBit(int temp){
        int indexBit = 0;
        while ((temp&1)!=1){
            temp = temp >>1;
            indexBit++;
        }
        return indexBit;
    }
    /**
     * 判断是第几组的数字
     * @param num 数组中的数
     * @param indexBit 依此与数组中的数字异或后的结果,取此结果二进制中首次出现1的下标
     * @return
     */
    private static boolean isGroup1(int num,int indexBit){
        num = num >> indexBit;
        return ((num&1)==1);
    }

    //题目2：数组中唯一只出现一次的数字，其他数字都出现了三次。
    private static void findNumAppearOnceInThreeArr(int [] num){
        int [] bitSum = new int[32];
        //把数组中数字的二进制表示的每一位都加起来
        for (int aNum:num) {
            int temp = 1;
            for (int i = 0;i<32;i++){
                if ((aNum&temp)!=0){
                    bitSum[i]++;
                }
                temp = temp << 1;
            }
        }
        int result = 0;
        for (int i = 31;i>=0;i--){
            result = result << 1;
            result += bitSum[i]%3;
        }
        System.out.println(result);
    }
}
