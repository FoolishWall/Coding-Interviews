package offer14;

/**
 * @author wall
 * @date 2018/10/8  22:08
 * @description 题目:三角数字塔问题(动态规划经典问题)
 * 设有一个三角形的数塔，顶点为根结点，每个结点有一个整数值。从顶点出发，可以向左走或向右走，
 * 要求从根结点开始，请找出一条路径，使路径之和最大，只要输出路径的和。
 *
 * 思路：从叶节点倒推回根。
 */
public class NumberTriangle {
    public static void main(String[] args) {
        int [][] number = new int[5][5];
        number[0][0] = 7;
        number[1][0] = 3;
        number[1][1] = 8;
        number[2][0] = 8;
        number[2][1] = 1;
        number[2][2] = 0;
        number[3][0] = 2;
        number[3][1] = 7;
        number[3][2] = 4;
        number[3][3] = 4;
        number[4][0] = 4;
        number[4][1] = 5;
        number[4][2] = 2;
        number[4][3] = 6;
        number[4][4] = 5;
        System.out.println(maxSum(number));
    }

    private static int maxSum(int[][] number){
        //从叶节点推回根节点
        for (int i=3;i>=0;--i){
            //将二维数组中的值依此替换为向左向右走的最大值
            for (int j=0;j<=i;++j){
                number[i][j] = (number[i+1][j]+number[i][j])>(number[i+1][j+1]+number[i][j])?number[i+1][j]+number[i][j]:number[i+1][j+1]+number[i][j];
            }
        }
        return number[0][0];
    }
}
