package exam58;

/**
 * @author wall
 * @data 2019/9/23 10:20
 * 最短路径
 **/
public class ShortPath {
    public static void main(String[] args) {
        int [][] arr = new int[][]{{1,3,4},{2,1,2},{4,3,1},{1,1,1}};
        System.out.println(getShortPath(arr));
    }

    private static int getShortPath(int[][] arr){
        if (arr.length < 1 || arr[0].length < 1){
            return 0;
        }
        int [][] dp = new int[arr.length][arr[0].length];
        int sum1 = 0 ;
        //初始化dp数组
        for (int i = 0 ; i < arr.length ; i++){
            sum1 += arr[i][0];
            dp[i][0] = sum1;
        }
        int sum2 = 0;
        for (int i = 0 ; i < arr[0].length ; i++){
            sum2 += arr[0][i];
            dp[0][i] = sum2;
        }
        //双重for循环
        for (int i = 1 ; i < arr.length ; i++){
            for (int j = 1; j < arr[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j]+arr[i][j],dp[i][j-1]+arr[i][j]);
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }
}
