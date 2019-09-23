package exam58;

/**
 * @author wall
 * @data 2019/9/23 9:54
 * 题目描述：有序整数集合，移除重复数字，使每个数字出现一次，输出最终数字的个数。
 *
 * 输入：
 * 1 2 2
 * 输出：
 * 2
 *
 * 解题思路：
 * ①利用HashSet
 * ②利用有序这个条件
 **/
public class ShowSingleNum {
    public static void main(String[] args) {
        int [] nums = new int[]{1,1,1,1,1,1,1,1,1,2,2,2,2,3,3,3};
        System.out.println(getLength(nums));
    }
    private static int getLength(int [] nums){
        if (nums.length < 1){
            return 0;
        }
        int count = 1;
        //遍历数组
        for (int i = 1;i<nums.length;i++){
            if (nums[i-1] != nums[i]){
                count ++;
            }
        }
        return count;
    }
}
