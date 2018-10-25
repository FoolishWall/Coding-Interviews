package offer47;

/**
 * @author wall
 * @date 2018/10/25  9:33
 * @description 礼物的最大值
 * 题目描述：从棋盘的左上角开始取格子里的礼物，每次向右或是向下移动，直到到达棋盘的右下角，计算累计拿到的最大值礼物。
 * 思路：动态规划
 * 定义函数f(i,j)表示到达坐标(i,j)的格子时能拿到的礼物总和的最大值。f(i,j)=max(f(i-1,j),f(i,j-1))+gift[i,j]。
 */
public class GiftMaxValue {
    //测试
    public static void main(String[] args) {
        //测试棋盘数据
        int [][] chessboardArr = new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5},{4,11,2,6}};
        System.out.println(getMaxValue_solution(chessboardArr));
        System.out.println(getMaxValue_solution1(chessboardArr));
    }
    //采用循环的方式遍历棋盘，计算每个格子的最大值
    private static int getMaxValue_solution(int [][] chessboardArr){
        if (chessboardArr==null){
            return -1;
        }
        //定义一个数组，存放f(i,j)
        int [][] tempArr = new int[chessboardArr.length][chessboardArr[0].length];
        //采用循环填充最大值数组
        for (int i=0;i<chessboardArr.length;++i){
            for (int j=0;j<chessboardArr[i].length;++j){
               int left =0;
               int up = 0;

               if (i>0){
                   left=tempArr[i-1][j];
               }

               if (j>0){
                   up=tempArr[i][j-1];
               }

               tempArr[i][j] = Math.max(left,up)+chessboardArr[i][j];
            }
        }

        return tempArr[chessboardArr.length-1][chessboardArr[0].length-1];
    }

    //进一步优化
    //最大价值只依赖坐标为(i-1,j)和(i,j-1)的两个格子，所以其他数据没必要保存下来。
    private static int getMaxValue_solution1(int [][] chessboardArr){
        int [] maxValue= new int[chessboardArr[0].length];

        //遍历棋盘
        for (int i=0;i<chessboardArr.length;++i){
            for (int j=0;j<chessboardArr[i].length;++j){
                int left=0;
                int up=0;
                if (i>0){
                    up=maxValue[j];
                }
                if (j>0){
                    left=maxValue[j-1];
                }
                maxValue[j]=Math.max(left,up)+chessboardArr[i][j];
            }
        }
        return maxValue[chessboardArr[0].length-1];
    }
}
