package offer12;


/**
 * @author wall
 * @date 2019/4/8  10:44
 * @description 素数环(利用DFS算法)
 * 题目：环由n个（偶数）圆组成，如图所示。将自然数1，2，…，n分别分成每个圆，
 * 两个相邻圆圈中的数字之和应该是一个素数。注意：第一个圆圈的数量应该始终为1。
 */
public class CirclePrime {
    //测试
    public static void main(String[] args) {
        int n = 8;
        boolean [] bool = new boolean[8];
        int [] result = new int[8];
        result[0] = 1;
        bool[0] = true;
        DFS(n,result,1,bool);
    }

    private static void DFS(int n,int [] result,int step,boolean [] bool){
        if (step == n){
            for (int i = 0 ; i < step;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }
        //遍历所有可能
        for (int i = 2;i <=n; i++){
            if (check(i,step,bool,result,n)) {
                result[step] = i;
                //标记已访问
                bool[i-1] = true;
                DFS(n,result,step+1,bool);
                bool[i-1] = false;
            }
        }
    }

    private static boolean check(int i,int step,boolean [] bool,int [] result,int n)
    {
        if (!bool[i-1] && isPrime(i+result[step -1])){
            //判断头尾
            if (step == n-1 && !isPrime(i + result[0])){
                return false;
            }
            return true;
        }
        return false;
    }

    //判断一个数是否为素数
    private static boolean isPrime(int m){
        if (m < 2){
            return false;
        }
        if (m <= 3){
            return true;
        }
        int sqrt = (int) Math.sqrt(m);

        for ( int i = 2 ; i <= sqrt;i++){
            if (m%i == 0){
                return false;
            }
        }
        return true;
    }
}
