package exam58;

import java.util.Arrays;

/**
 * @author wall
 * @data 2019/9/23 10:59
 * 分饼干
 **/
public class DivCookie {
    public static void main(String[] args) {
        int [] score = new int[]{3,6,3,2};
        System.out.println(getNumCookie(score));
    }
    private static int getNumCookie(int [] ratings){
        //初始化饼干数组
        int [] left2right = new int[ratings.length];
        int [] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        //先从左至右遍历一遍
        for (int i = 1;i < ratings.length;i++){
            if (ratings[i] > ratings[i-1]){
                left2right[i] = left2right[i-1]+1;
            }
        }
        //再从右至左遍历一遍
        for (int i = ratings.length -2;i>=0;i--){
            if (ratings[i] > ratings[i+1]){
                right2left[i] = right2left[i+1]+1;
            }
        }
        int sum = 0;
        for (int i = 0 ; i < ratings.length; i++){
            sum += Math.max(left2right[i],right2left[i]);
        }
        return sum;
    }
}
