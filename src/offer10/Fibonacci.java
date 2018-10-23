package offer10;

/**
 * @author wall
 * @date 2018/10/23  16:21
 * @description 斐波那契数列
 */
public class Fibonacci {
    //测试
    public static void main(String[] args) {
        System.out.println(fibonacci_solution(10));
        System.out.println(fibonacci_solution1(10));
        System.out.println(fibonacci_solution2(10));
    }

    //斐波那契（低效率递归解法）
    private static int fibonacci_solution(int n){
        if (n<=0){return 0;}
        if (n==1){return 1;}
        return fibonacci_solution(n-1)+fibonacci_solution(n-2);
    }
    //斐波那契（高效率动态规划解法）
    private static int fibonacci_solution1(int n){
        //定义存放每一步结果的数组
        int [] result = new int[n+1];
        //自下而上，避免重复计算
        //初始化0,1
        result[0]=0;
        result[1]=1;
        for (int i=2;i<=n;++i){
            result[i]=result[i-1]+result[i-2];
        }

        return result[n];
    }
    //以上解法占用存储空间
    //不需要存储每步的结果
    private static int fibonacci_solution2(int n){
        if (n<=0){return 0;}
        if (n==1){return 1;}
        int fibNone = 1;
        int fibNtwo = 0;
        int fibN = 0;
        for (int i=1;i<n;++i){
            fibN=fibNone+fibNtwo;
            fibNtwo=fibNone;
            fibNone=fibN;
        }
        return fibN;
    }
}
