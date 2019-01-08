package offer60;


/**
 * @author wall
 * @date 2018/11/8  10:47
 * @description N个骰子的点数之和出现的概率
 * 思路:自下向上的思路
 * 本质是求数列：f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6)
 * 加入一个新骰子，此时和为n的骰子出现的次数应该等于没加入新骰子时骰子点数为n-1、
 * n-2、n-3、n-4,n-5,n-6的次数的总和
 */
public class PrintDicePossibility {
    //测试
    public static void main(String[] args) {
        int n = 3;
        printDicePossibility(n);
    }

    /**
     * 基于循环的解法
     * @param n 骰子数
     */
    private static void printDicePossibility(int n) {
        //边界条件
        if (n < 1) {
            return;
        }
        //考虑程序的扩展性，将骰子的点数设为变量
        int diceMax = 6;

        //加入新骰子之前,定义一个数组存储所有可能的点数出现的次数
        //+1是因为都是从数组下标1开始
        int[] timeBefore = new int[6 * n + 1];
        //定义一个数组存储所有可能的点数出现的次数，数组大小为6*n-n+1
        int[] timesArr = new int[6 * n + 1];

        //初始化当骰子只有一个时的数组
        //从数组下标1开始
        for (int i = 1; i <= diceMax; ++i) {
            timeBefore[i] = 1;
        }

        //循环一次，加入一个骰子，更新点数出现的次数
        //k为骰子数
        for (int k = 2; k <= n; k++) {
            //m为可能出现的点数和
            for (int m = k; m <= k * diceMax; m++) {
                //控制f(m)=f(m-1)+f(m-2)+f(m-3)+f(m-4)+f(m-5)+f(m-6)
                //控制数组不要越界
                int index = m - 1;
                //控制只循环6次
                int count = 0;
                //记录n-1、n-2、n-3、n-4,n-5,n-6的次数的总和
                int sum = 0;
                while (index >= 1) {
                    sum += timeBefore[index];
                    index--;
                    count++;
                    if (count == 6) {
                        break;
                    }
                }
                timesArr[m] = sum;
            }
            //循环一次结束时，将timeBefore中的值替换为timeArr中的值
            timeBefore = timesArr.clone();

        }

        //最小点数 n
        //最大点数
        int maxSum = 6 * n;
        //总的出现次数
        int totalNumber = (int) Math.pow(6, n);
        double ratio;
        //循环显示点数和出现的概率
        for (int j = n; j <= maxSum; j++) {
            if (n==1){
                System.out.println(timeBefore[j]);
                //当前概率
                ratio = (double) timeBefore[j] / totalNumber;
            }else {
                System.out.println(timesArr[j]);
                //当前概率
                ratio = (double) timesArr[j] / totalNumber;
            }

            System.out.println("点数和为:" + j + "出现的概率为:" + ratio);
        }
    }
}
