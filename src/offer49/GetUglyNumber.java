package offer49;

/**
 * @author wall
 * @date 2018/11/9  10:14
 * @description 丑数
 * 题目描述：把只包含因子2,3,5的数称作丑数
 * 求从小到大的顺序的第1500个丑数
 * 1为第一个丑数
 *
 * 用空间换时间的解法
 * 丑数应该是另一个丑数乘以2,3或者5的结果(1除外)
 */
public class GetUglyNumber {
    //测试
    public static void main(String[] args) {
        int number = 1;
        System.out.println(getUglyNumber_optsolution(1500));
    }
    //判断一个数是丑数
    private static boolean  isUgly(int number){
        while (number%2==0){
            number=number/2;
        }
        while (number%3==0){
            number=number/3;
        }
        while (number%5==0){
            number=number/5;
        }
        return number==1;
    }
    //求第n个丑数
    //时间效率低，原因：判断了非丑数
    private static int getUglyNumber_solution(int n){
        int count = 0;

        for (int number = 1;number<Integer.MAX_VALUE;number++){
            if (isUgly(number)){
                count++;
            }
            if (count==n){
                return number;
            }
        }
        return 0;
    }

    //用空间换时间的解法,丑数应该是另一个丑数乘以2,3或者5的结果(1除外)
    private static int getUglyNumber_optsolution(int n) {
        //记录排序好的丑数
        int[] uglyNumber = new int[n];
        //初始化
        uglyNumber[0] = 1;
        //把已有的最大丑数记为M
        //把得到的第一个乘以2后大于M的结果记为M2
        int m2 = 0;
        //M3
        int m3 = 0;
        //M5
        int m5 = 0;

        //乘以2系列的下标
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            //求M2,M3,M5
            while ( 2 * uglyNumber[index2] <= uglyNumber[i - 1]) {
                index2++;
            }
            m2 = 2 * uglyNumber[index2];

            while ( 3 * uglyNumber[index3] <= uglyNumber[i - 1]) {
                index3++;
            }
            m3 = 3 * uglyNumber[index3];

            while ( 5 * uglyNumber[index5] <= uglyNumber[i - 1]) {
                index5++;
            }
            m5 = 5 * uglyNumber[index5];


            uglyNumber[i] = m5<(m2<m3?m2:m3)?m5:(m2<m3?m2:m3);


        }
        return uglyNumber[n - 1];
    }
}
