package classic;

import java.util.Stack;

/**
 * @author wall
 * @date 2019/7/22  9:31
 * @description 背包问题的分类
 *
 * 0-1背包, 每个物品只能取0个,或者1个.
 * 完全背包, 每个物品可以取无限次.
 * 多重背包, 每种物品都有个数限制, 第i个物品最多可以为num[i]个.
 *
 */
public class Backpack {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{1,8,3,5};
        int value = 10;
        int [] cost = new int[]{30,10,120,100};
        int [] number = new int[]{1,2,3,4};
//        novalue(data,value);
//        valueLimit(data,value,cost);
//        numberNoLimit(data,value,cost);
        numberLimit(data,value,cost,number);
    }

    //（1）经典的0-1背包问题（无物品的价值）：
    //假设有一个能装入容量为C的背包和n件重量分别为w1,w2,,...,wn的物品，能否从n件物品中挑选若干件恰好装满背包,要求找出所有满足上述条件的解。
    //当C=10,各件物品重量为{1,8,4,3,5,2}时，可以找到下列4组解：(1,4,3,2)、(1,4,5)、(8,2)和(3,5,2)。

    //根据这个问题的一个变形是：
    //已知一个数为C，一个长度为n的无序的数组，分别是数w1,w2,...,wn，能否从这n个数中找到若干个数使其和等于数C,要求找出所有满足上述条件的解。

    /**
     * 相似问题：给定一个仅包含正整数的非空数组，确定该数组是否可以分成两部分，要求两部分的和相等
     *
     * 思路：求数组元素的和sum,在数组中找到和为sum/2的数组子集，则剩下的数组元素和也为sum/2,如果sum%2不为0，直接放回false。
     */

    /**
     * 利用栈实现的回溯法
     * @param data 物品重量
     * @param value 背包的称重量
     */
    private static void novalue(int[] data, int value){
        //利用栈实现回溯
        Stack<Integer> stack = new Stack<>();
        //物品的数量
        int n = data.length;
        int k = 0;
        do{
        while (value > 0 && k < n){
            //栈中保存数组的下标
            stack.push(k);
            //更新value的值
            value -= data[k];
            k++;
        }
        if (value == 0){
            stack.forEach((index)-> System.out.print(data[index]+" "));
            System.out.println();
        }
        //取得栈顶元素
        k = stack.peek();
        value += data[k];
        stack.pop();
        //从下一个数开始判断
        k++;
        }while (!(stack.isEmpty()&&k==n));
    }

    /**
     * @param data 物品的重量
     * @param value 背包的承重量
     * @param cost 物品的价值
     */
    @SuppressWarnings("unchecked")
    private static void valueLimit(int [] data,int value,int [] cost){
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> result = new Stack<>();

        int maxValue = Integer.MIN_VALUE;
        int k = 0;
        int tempCost = 0;
        int n = data.length;
        do{
            while (value > 0&& k<n){
                temp.push(k);
                //更新价值
                tempCost += cost[k];
                //更新背包重量
                value -= data[k];
                k++;
            }
            //记录最大值
            if (tempCost > maxValue){
                maxValue = tempCost;
                //拷贝栈
                result = (Stack<Integer>) temp.clone();
            }

            //回溯
            //获取栈顶元素
            k = temp.peek();
            //更新价值
            value += data[k];
            tempCost -= cost[k];
            temp.pop();
            //判断下个元素
            k++;
        }while (!(temp.isEmpty()&&k == n));
        System.out.println("最大价值:"+maxValue);
        result.forEach((index)-> System.out.print(data[index]+" "));
    }


    /**
     * 完全背包问题
     * 这种背包问题可以用贪心算法求解，先计算每种物品单位重量的价值vi/wi;然后根据贪心策略，将可能多得单位重量价值最高的物品装入背包；
     * 依次使用这种策略，直至装满背包为止。
     * @param data 物品重量
     * @param value 背包承重量
     * @param cost 物品价值
     */
    private static void numberNoLimit(int [] data ,int value,int []cost){
        double[] unit = new double[data.length];
        //记录是否已经装入背包，以便找到下一个最大值
        boolean [] isPack = new boolean[data.length];
        for (int i = 0 ; i < data.length;i++){
            //这里乘以1.0解决类型转换问题
            unit[i] = cost[i]*1.0/data[i];
        }
        double maxUnit;
        int maxUnitIndex = -1;
        int maxCost = 0;
        while (value > 0) {
            maxUnit = -1;
            //找到最大的单位价值物品的下标
            for (int j = 0; j < data.length; j++) {
                if (!isPack[j] && (unit[j] > maxUnit)) {
                    maxUnit = unit[j];
                    maxUnitIndex = j;
                }
            }
            isPack[maxUnitIndex] = true;
            //尽量将此物品装入背包
            while (value >= data[maxUnitIndex]){
                maxCost += cost[maxUnitIndex];
                //更新价值
                value -= data[maxUnitIndex];
            }
        }
        System.out.println("最大价值为："+maxCost);
    }

    /**
     * 多重背包问题限定了一种物品的个数，解决多重背包问题，只需要把它转化为0-1背包问题即可。比如，有2件价值为5，重量为2的同一物品，
     * 我们就可以分为物品a和物品b，a和b的价值都为5，重量都为2，但我们把它们视作不同的物品。
     * @param data 物品的重量
     * @param value 背包的承重量
     * @param cost 物品的价值
     * @param number 物品的个数
     */
    private static void numberLimit(int [] data,int value,int [] cost,int [] number){
        //总物品数
        int sum = 0;
        for (int n:number){
            sum += n;
        }

        int [] dataNew = new int[sum];
        int [] valueNew = new int[sum];

        int start = 0;
        //重新构建物品重量，价值数组
        for (int r = 0 ; r < number.length;r++){
            for (int s = start;s < start+number[r]; s++){
                dataNew[s] = data[r];
                valueNew[s] = cost[r];
            }
            start += number[r];
        }

        for (int aDataNew : dataNew) {
            System.out.print(aDataNew + " ");
        }
        System.out.println();
        for (int aValueNew : valueNew) {
            System.out.print(aValueNew+ " ");
        }

        //利用0-1背包问题解决
        valueLimit(dataNew,value,valueNew);
    }
}
