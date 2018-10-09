package offer14;

/**
 * @author wall
 * @date 2018/10/7  21:31
 * @description 题目：给你一根长度为n的绳子，请把绳子剪成m段(m,n都是整数，n>1并且m>1)，
 * 每段绳子的长度记为k[0],k[1],...k[m]。请问k[0]*k[1]*...k[m]可能的最大乘积是多少?
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18。
 */
public class MaxProductAfterCutting {
    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_solution(15));
        System.out.println(maxProductAfterCutting_solution1(15));
    }

    /**
     * 动态规划
     * 思路：从下而上的顺序计算，先得到f(2),f(3),再得到f(4),f(5),直到得到f(n)。
     * @param length
     * @return
     */
    private static int maxProductAfterCutting_solution(int length){
        if (length<2)
            return 0;
        if (length==2)
            return 1;
        if (length==3)
            return 2;
        //定义一个数组，保存子问题的最优解
        int[] products = new int[length+1];
        //初始化数组中的值
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        products[4]=4;

        //最优解
        int max = 0;

        //自下向上依此求解子问题的最优解
        for (int i =5;i<=length;++i){
            //考虑所有子问题的组合
            for (int j = 1;j<=i/2;++j){
                max = products[j]*products[i-j];
                if (max>products[i]){
                    products[i] = max;
                }
            }
        }

        return products[length];
    }

    /**
     * 贪婪算法
     * 思路：当n>=5时，尽可能多的剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
     * @param length
     * @return
     */
    private static int maxProductAfterCutting_solution1(int length){
        if (length<2){return 0;}
        if (length==2){return 1;}
        if (length==3){return 2;}
        //尽可能多的剪长度为3
        int temp1 = length/3;
        //获取余数
        int temp2 = length%3;

        //当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
        if (temp2==1){
            return (int) Math.pow(3,temp1-1)*4;
        }
        if (temp2==2){
            return (int) Math.pow(3,temp1)*2;
        }
        if (temp2==0){
            return (int) Math.pow(3,temp1);
        }
        return 0;
    }
}
