package offer61;

import java.util.Arrays;

/**
 * @author wall
 * @date 2018/11/7  13:51
 * @description 扑克牌中的顺子
 * 例如：判断一个数组中的五个数字是不是连续的，0为大小王，可以充当任何数字
 * {0,1,3,4,5}为一个顺子
 */
public class PokerStraight {
    //测试
    public static void main(String[] args) {
        //暂不考虑输入数字的合法性
        int [] pokerArr = new int[]{9,10,0,0,12};
        System.out.println(isStraight(pokerArr));
    }

    private static boolean isStraight(int [] pokerArr){
        if (pokerArr==null||pokerArr.length<5){
            return false;
        }

        Arrays.sort(pokerArr);

        //统计0的个数
        int count0 = 0;
        for (int aPokerArr:pokerArr){
            if (aPokerArr==0){
                count0++;
            }
        }

        //遍历排序后的数组
        for (int i=count0;i<pokerArr.length-1;i++){
            int temp = pokerArr[i+1] -pokerArr[i];
            //如果出现重复数字，则数组不连续
            if (temp==0){
                return false;
            }
            while (temp>1){
                count0--;
                temp--;
            }
        }

        return count0 >= 0;

    }
}
